package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.constant.PaymentMethod;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.dto.response.PurchaseResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public class OrderConfirmationRequest {

    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customer;
    private List<PurchaseResponse> purchasedProducts;
}
