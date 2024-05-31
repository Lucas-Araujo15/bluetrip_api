package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
