package com.anup.ecommerce.entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated // Remove this later and implement validation outside of entity
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
