package com.anup.ecommerce.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class PurchaseRequest {
    @NotNull(message = "Product id is required")
    private Long productId;

    @Positive(message = "Product quantity must be greater than 0")
    private double quantity;
}
