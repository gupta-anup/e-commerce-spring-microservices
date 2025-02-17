package com.anup.ecommerce.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductUpdateRequest {
    private String name;

    private String description;

    @Positive(message = "Product available quantity must be greater than 0")
    private Double availableQuantity;

    @Positive(message = "Product price must be greater than 0")
    private BigDecimal price;

    private Integer categoryId;
}
