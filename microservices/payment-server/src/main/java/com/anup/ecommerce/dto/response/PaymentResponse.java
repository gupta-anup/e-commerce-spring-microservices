package com.anup.ecommerce.dto.response;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class PaymentResponse {
    private Integer id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Integer orderId;
}
