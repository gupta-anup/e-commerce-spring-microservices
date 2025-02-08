package com.anup.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

// We are using CustomException instead of CustomerNotFoundException
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
