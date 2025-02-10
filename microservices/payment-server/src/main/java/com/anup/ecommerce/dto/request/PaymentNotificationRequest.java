package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PaymentNotificationRequest {

    private String orderReference;
    private BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstName;
    String customerLastName;
    String customerEmail;
}
