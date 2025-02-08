package com.anup.ecommerce.controller;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerCreateRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}
