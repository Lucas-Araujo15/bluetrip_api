package com.api.bluetrip.controllers.dtos.booking;

import com.api.bluetrip.controllers.dtos.payment.PaymentRegisterDTO;

import java.time.LocalDateTime;

public record BookingRegisterDTO(
        Long touristId,
        Long touristSpotId,
        int quantity,
        LocalDateTime dateBooking,

        PaymentRegisterDTO payment
) {
}
