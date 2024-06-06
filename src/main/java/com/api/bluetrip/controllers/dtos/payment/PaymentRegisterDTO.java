package com.api.bluetrip.controllers.dtos.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentRegisterDTO(
        @NotBlank
        String paymentMethod,

        @NotNull
        float totalPrice
) {
}
