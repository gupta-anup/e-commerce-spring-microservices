package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.entity.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {
    public static Customer toEntity(CustomerCreateRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
    }

    public static CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
