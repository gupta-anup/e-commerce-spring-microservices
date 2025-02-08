package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.entity.Customer;
import com.anup.ecommerce.mapper.CustomerMapper;
import com.anup.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        Customer customer = CustomerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.toResponse(savedCustomer);
    }
}
