package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.request.CustomerUpdateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.entity.Customer;
import lombok.experimental.UtilityClass;

import java.util.List;

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

    public static Customer toEntity(Customer existingCustomer, CustomerUpdateRequest request) {
        if(request.getFirstName() != null) {
            existingCustomer.setFirstName(request.getFirstName());
        }
        if(request.getLastName() != null) {
            existingCustomer.setLastName(request.getLastName());
        }
        if(request.getEmail() != null) {
            existingCustomer.setEmail(request.getEmail());
        }
        if(request.getAddress() != null) {
            existingCustomer.setAddress(request.getAddress());
        }

        return existingCustomer;
    }

    public static CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }

    public static List<CustomerResponse> toResponseList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerMapper::toResponse)
                .toList();
    }
}
