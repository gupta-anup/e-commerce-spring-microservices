package com.anup.ecommerce.controller;

import com.anup.ecommerce.dto.request.PaymentCreateRequest;
import com.anup.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentCreateRequest request) {
        return ResponseEntity.ok(paymentService.createPayment(request));
    }
}
