package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.payment.DetailedPaymentDTO;
import com.api.bluetrip.controllers.dtos.payment.PaymentUpdateDTO;
import com.api.bluetrip.models.Payment;
import com.api.bluetrip.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public DetailedPaymentDTO update(Long id, PaymentUpdateDTO paymentUpdateDTO) {
        Payment payment = paymentRepository.getReferenceById(id);

        payment.updateInformation(paymentUpdateDTO);

        paymentRepository.save(payment);

        return new DetailedPaymentDTO(payment);
    }
}
