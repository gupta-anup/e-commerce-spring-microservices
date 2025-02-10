package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.*;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.dto.response.PurchaseResponse;
import com.anup.ecommerce.entity.Order;
import com.anup.ecommerce.mapper.OrderMapper;
import com.anup.ecommerce.mapper.PaymentMapper;
import com.anup.ecommerce.ms_client.CustomerClient;
import com.anup.ecommerce.ms_client.PaymentClient;
import com.anup.ecommerce.ms_client.ProductClient;
import com.anup.ecommerce.dto.response.OrderResponse;
import com.anup.ecommerce.exception.CustomException;
import com.anup.ecommerce.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderProducerService orderProducerService;
    private final PaymentClient paymentClient;

    public Long createOrder(@Valid OrderCreateRequest request) {
        // Check if the Customer exists -> customer-server (1-FeignClient)
        CustomerResponse customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new CustomException("Customer not found", HttpStatus.NOT_FOUND));

        // Purchase the product -> product-server (2-RestTemplate)
        List<PurchaseResponse> purchaseResponses = productClient.purchaseProducts(request.getPurchaseItems());

        // Persist the order
        Order order = OrderMapper.toEntity(request);
        Order savedOrder = orderRepository.save(order);

        // Persist the order line
        for(PurchaseRequest purchaseRequest: request.getPurchaseItems()) {
            OrderLineCreateRequest orderLineCreateRequest = OrderLineCreateRequest.builder()
                    .orderId(savedOrder.getId())
                    .productId(purchaseRequest.getProductId())
                    .quantity(purchaseRequest.getQuantity())
                    .build();

            orderLineService.saveOrderLine(orderLineCreateRequest);
        }

        // Start the payment process
        PaymentRequest paymentRequest = PaymentMapper.toRequest(savedOrder, customer);
        paymentClient.processPayment(paymentRequest);

        // Send the order confirmation notification -> notification-server (kafka)
        OrderConfirmationRequest orderConfirmationRequest = OrderConfirmationRequest.builder()
                .orderReference(request.getReference())
                .totalAmount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .customer(customer)
                .purchasedProducts(purchaseResponses)
                .build();

        orderProducerService.sendOrderConfirmation(orderConfirmationRequest);

        return savedOrder.getId();
    }

    public List<OrderResponse> getAllOrders() {
        return OrderMapper.toResponse(orderRepository.findAll());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException("Order not found", HttpStatus.NOT_FOUND));

        return OrderMapper.toResponse(order);
    }
}
