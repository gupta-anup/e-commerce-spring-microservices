package com.anup.ecommerce.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
}
