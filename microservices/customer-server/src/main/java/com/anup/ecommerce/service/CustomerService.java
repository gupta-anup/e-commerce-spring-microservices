package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.CustomerCreateRequest;
import com.anup.ecommerce.dto.request.CustomerUpdateRequest;
import com.anup.ecommerce.dto.response.CustomerResponse;
import com.anup.ecommerce.entity.Customer;
import com.anup.ecommerce.exception.CustomException;
import com.anup.ecommerce.mapper.CustomerMapper;
import com.anup.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        // Check for duplicate email later
        Customer customer = CustomerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.toResponse(savedCustomer);
    }

    public CustomerResponse updateCustomer(String id, CustomerUpdateRequest request) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Customer not found with id: %s", id),
                        HttpStatus.NOT_FOUND
                ));

        // Check for duplicate email later
        Customer customer = CustomerMapper.toEntity(existingCustomer, request);

        Customer updatedCustomer = customerRepository.save(customer);

        return CustomerMapper.toResponse(updatedCustomer);
    }

    public List<CustomerResponse> getAllCustomers() {
        // Apply pagination later
        List<Customer> customers = customerRepository.findAll();

        return CustomerMapper.toResponseList(customers);
    }

    public CustomerResponse getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Customer not found with id: %s", id),
                        HttpStatus.NOT_FOUND
                ));

        return CustomerMapper.toResponse(customer);
    }

    public boolean customerExists(String id) {
        return customerRepository.existsById(id);
    }

    public void deleteCustomer(String id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Customer not found with id: %s", id),
                        HttpStatus.NOT_FOUND
                ));

        customerRepository.deleteById(id);
    }
}
