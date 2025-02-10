package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.PaymentCreateRequest;
import com.anup.ecommerce.dto.request.PaymentNotificationRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NotificationMapper {

    public static PaymentNotificationRequest toRequest(PaymentCreateRequest request) {
        return PaymentNotificationRequest.builder()
                .orderReference(request.getOrderReference())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .customerFirstName(request.getCustomer().getFirstName())
                .customerLastName(request.getCustomer().getLastName())
                .customerEmail(request.getCustomer().getEmail())
                .build();
    }
}
