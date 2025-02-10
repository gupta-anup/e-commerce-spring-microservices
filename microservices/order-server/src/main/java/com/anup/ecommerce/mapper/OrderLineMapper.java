package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.OrderLineCreateRequest;
import com.anup.ecommerce.dto.response.OrderLineResponse;
import com.anup.ecommerce.entity.Order;
import com.anup.ecommerce.entity.OrderLine;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderLineMapper {
    public static OrderLine toEntity(OrderLineCreateRequest request) {
        return OrderLine.builder()
                .order(
                        Order.builder()
                                .id(request.getOrderId())
                                .build()
                )
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();
    }

    public static OrderLineResponse toResponse(OrderLine orderLine) {
        return OrderLineResponse.builder()
                .id(orderLine.getId())
                .quantity(orderLine.getQuantity())
                .build();
    }

    public static List<OrderLineResponse> toResponse(List<OrderLine> orderLines) {
        return orderLines.stream()
                .map(OrderLineMapper::toResponse)
                .toList();
    }
}
