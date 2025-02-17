package com.anup.ecommerce.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Product {

        private Integer productId;
        private String name;
        private String description;
        private BigDecimal price;
        private double quantity;
}