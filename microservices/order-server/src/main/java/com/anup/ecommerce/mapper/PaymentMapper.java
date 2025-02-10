package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.PaymentRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.entity.Order;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMapper {

    public static PaymentRequest toRequest(Order request, CustomerResponse customer) {
        return PaymentRequest.builder()
                .orderId(request.getId())
                .orderReference(request.getReference())
                .amount(request.getTotalAmount())
                .paymentMethod(request.getPaymentMethod())
                .customer(customer)
                .build();
    }
}
