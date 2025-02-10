package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.OrderLineCreateRequest;
import com.anup.ecommerce.entity.Order;
import com.anup.ecommerce.entity.OrderLine;
import lombok.experimental.UtilityClass;

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
}
