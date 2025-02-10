package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.PaymentCreateRequest;
import com.anup.ecommerce.dto.response.PaymentResponse;
import com.anup.ecommerce.entity.Payment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {

    public static Payment toEntity(PaymentCreateRequest request) {
        return Payment.builder()
                .orderId(request.getOrderId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getAmount())
                .build();
    }

    public static PaymentResponse toResponse(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .amount(payment.getAmount())
                .build();
    }
}
