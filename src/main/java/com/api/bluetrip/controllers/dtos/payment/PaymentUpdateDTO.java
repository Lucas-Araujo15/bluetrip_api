package com.api.bluetrip.controllers.dtos.payment;

import java.time.LocalDateTime;

public record PaymentUpdateDTO(
        String statusPayment,
        LocalDateTime datePayment
) {
}
