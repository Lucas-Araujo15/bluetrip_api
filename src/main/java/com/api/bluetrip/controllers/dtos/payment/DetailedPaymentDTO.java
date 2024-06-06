package com.api.bluetrip.controllers.dtos.payment;

import com.api.bluetrip.models.Payment;

import java.time.LocalDateTime;

public record DetailedPaymentDTO(
        String paymentMethod,
        float totalPrice,
        String statusPayment,
        LocalDateTime datePayment
) {
    public DetailedPaymentDTO(Payment payment) {
        this(payment.getPaymentMethod(), payment.getTotalPrice(), payment.getStatusPayment(), payment.getDatePayment());
    }
}
