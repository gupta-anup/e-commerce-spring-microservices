package com.anup.ecommerce.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class PurchaseResponse {

    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
