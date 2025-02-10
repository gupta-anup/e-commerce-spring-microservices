package com.anup.ecommerce.repository;

import com.anup.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
