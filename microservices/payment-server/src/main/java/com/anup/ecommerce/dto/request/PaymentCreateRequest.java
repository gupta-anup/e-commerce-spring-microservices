package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentCreateRequest {
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Long orderId;
    String orderReference;
    CustomerRequest customer;
}
