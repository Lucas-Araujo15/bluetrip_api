package com.api.bluetrip.controllers.dtos.serviceusage;

import com.api.bluetrip.controllers.dtos.payment.PaymentRegisterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ServiceUsageRegisterDTO(
        @NotNull
        LocalDateTime dateUsage,

        @NotNull
        Long serviceId,

        @NotNull
        Long touristId,

        @Valid
        PaymentRegisterDTO paymentRegisterDTO
) {
}
