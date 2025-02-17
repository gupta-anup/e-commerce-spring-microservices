package com.anup.ecommerce.ms_client;

import com.anup.ecommerce.dto.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-server", url = "${application.config.payment-server.url}")
public interface PaymentClient {

    @PostMapping
    Integer processPayment(@RequestBody PaymentRequest paymentRequest);
}
