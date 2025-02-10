package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderCreateRequest {
    private String reference;

    @Positive(message = "Order amount must be greater than 0")
    private BigDecimal totalAmount;

    @NotBlank(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotEmpty(message = "Purchase items are required")
    private List<PurchaseRequest> purchaseItems;
}
