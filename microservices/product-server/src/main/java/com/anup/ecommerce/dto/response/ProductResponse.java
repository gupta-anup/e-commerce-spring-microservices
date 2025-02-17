package com.anup.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private CategoryResponse category;
}
