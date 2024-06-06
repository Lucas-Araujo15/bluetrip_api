package com.api.bluetrip.controllers.dtos.booking;

import com.api.bluetrip.controllers.dtos.payment.DetailedPaymentDTO;
import com.api.bluetrip.models.Booking;

import java.time.LocalDateTime;

public record DetailedBookingDTO(
    LocalDateTime dateBooking,
    String statusBooking,
    int quantity,
    DetailedPaymentDTO payment
) {
    public DetailedBookingDTO(Booking booking) {
        this(booking.getDateBooking(), booking.getStatusBooking(), booking.getQuantity(), new DetailedPaymentDTO(booking.getPayment()));
    }
}
