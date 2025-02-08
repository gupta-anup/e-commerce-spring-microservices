package com.anup.ecommerce.controller;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.request.CustomerUpdateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerCreateRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

//    @GetMapping
//    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String id) {
//        return ResponseEntity.ok(customerService.getCustomerById(id));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable String id, @RequestBody @Valid CustomerUpdateRequest request) {
        return ResponseEntity.ok(customerService.updateCustomer(id, request));
    }
}
