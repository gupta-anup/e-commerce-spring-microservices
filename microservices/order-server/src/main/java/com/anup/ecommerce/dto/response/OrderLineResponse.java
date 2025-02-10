package com.anup.ecommerce.dto.response;

import lombok.Builder;

@Builder
public class OrderLineResponse {

    private Long id;
    private double quantity;
}
