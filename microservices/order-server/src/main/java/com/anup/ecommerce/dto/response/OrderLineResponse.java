package com.anup.ecommerce.dto.response;

import lombok.Builder;

@Builder
public class OrderLineResponse {

    private Integer id;
    private double quantity;
}
