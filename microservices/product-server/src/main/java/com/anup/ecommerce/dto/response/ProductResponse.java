package com.anup.ecommerce.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
