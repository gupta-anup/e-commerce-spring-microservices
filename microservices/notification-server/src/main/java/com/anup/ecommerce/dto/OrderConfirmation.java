package com.anup.ecommerce.dto;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Customer customer;
    private List<Product> products;
}
