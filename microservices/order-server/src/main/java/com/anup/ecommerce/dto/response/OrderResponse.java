package com.anup.ecommerce.dto.response;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class OrderResponse {
    private Integer id;
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private String customerId;
}
