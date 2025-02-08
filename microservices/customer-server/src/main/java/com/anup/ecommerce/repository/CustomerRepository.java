package com.anup.ecommerce.repository;

import com.anup.ecommerce.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
