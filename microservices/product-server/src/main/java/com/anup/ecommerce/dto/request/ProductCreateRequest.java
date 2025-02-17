package com.anup.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductCreateRequest {
    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    private String description;

    @NotNull(message = "Product available quantity is required")
    @Positive(message = "Product available quantity must be greater than 0")
    private double availableQuantity;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Product category id is required")
    private Integer categoryId;
}
