package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentCreateRequest {
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private CustomerRequest customer;
}
