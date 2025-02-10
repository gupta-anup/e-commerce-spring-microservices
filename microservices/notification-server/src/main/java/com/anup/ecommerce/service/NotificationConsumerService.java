package com.anup.ecommerce.service;

import com.anup.ecommerce.constant.NotificationType;
import com.anup.ecommerce.dto.OrderConfirmation;
import com.anup.ecommerce.dto.PaymentConfirmation;
import com.anup.ecommerce.mapper.NotificationMapper;
import com.anup.ecommerce.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumerService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consuming the message from payment-topic Topic:: {}", paymentConfirmation);

        notificationRepository.save(NotificationMapper.toEntity(NotificationType.PAYMENT_CONFIRMATION, paymentConfirmation));

        // Send email to customer
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.getCustomerEmail(),
                String.format("%s %s", paymentConfirmation.getCustomerFirstname(), paymentConfirmation.getCustomerLastname()),
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming the message from order-topic Topic:: {}", orderConfirmation);

        notificationRepository.save(NotificationMapper.toEntity(NotificationType.ORDER_CONFIRMATION, orderConfirmation));

        // Send email to customer
        emailService.sendOrderSuccessEmail(
                orderConfirmation.getCustomer().getEmail(),
                String.format("%s %s", orderConfirmation.getCustomer().getFirstname(), orderConfirmation.getCustomer().getLastname()),
                orderConfirmation.getTotalAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );
    }
}
