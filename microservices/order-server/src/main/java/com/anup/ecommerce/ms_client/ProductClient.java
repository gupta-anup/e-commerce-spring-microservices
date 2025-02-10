package com.anup.ecommerce.ms_client;

import com.anup.ecommerce.dto.request.PurchaseRequest;
import com.anup.ecommerce.dto.response.PurchaseResponse;
import com.anup.ecommerce.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-server.url}")
    private String productServerUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> purchaseRequests) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> request = new HttpEntity<>(purchaseRequests, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<PurchaseResponse>> response = restTemplate.exchange(
                productServerUrl + "/purchase",
                HttpMethod.POST,
                request,
                responseType
        );

        if(response.getStatusCode().isError()) {
            throw new CustomException(
                    "Error occurred while purchasing the products",
                    (HttpStatus) response.getStatusCode()
            );
        }
        return response.getBody();
    }
}
