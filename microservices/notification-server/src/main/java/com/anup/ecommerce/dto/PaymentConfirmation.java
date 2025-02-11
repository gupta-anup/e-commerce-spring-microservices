package com.anup.ecommerce.dto;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentConfirmation {
    private String orderReference;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
}