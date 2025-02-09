package com.anup.ecommerce.controller;

import com.anup.ecommerce.dto.request.ProductCreateRequest;
import com.anup.ecommerce.dto.request.ProductPurchaseRequest;
import com.anup.ecommerce.dto.response.ProductResponse;
import com.anup.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductCreateRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductResponse>> purchaseProducts(@RequestBody List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductCreateRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }
}
