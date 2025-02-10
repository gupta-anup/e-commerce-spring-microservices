package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import com.anup.ecommerce.dto.response.CustomerResponse;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class PaymentRequest {
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private CustomerResponse customer;
}
