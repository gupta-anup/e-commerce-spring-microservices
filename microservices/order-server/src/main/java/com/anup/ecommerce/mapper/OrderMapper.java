package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.OrderCreateRequest;
import com.anup.ecommerce.dto.response.OrderResponse;
import com.anup.ecommerce.entity.Order;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderMapper {
    public static Order toEntity(OrderCreateRequest request) {
        return Order.builder()
                .customerId(request.getCustomerId())
                .reference(request.getReference())
                .totalAmount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .build();
    }

    public static OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .reference(order.getReference())
                .totalAmount(order.getTotalAmount())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }

    public static List<OrderResponse> toResponse(List<Order> orders) {
        return orders.stream()
                .map(OrderMapper::toResponse)
                .toList();
    }
}
