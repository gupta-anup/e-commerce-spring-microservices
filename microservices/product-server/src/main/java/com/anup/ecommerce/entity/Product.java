package com.anup.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
//    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
