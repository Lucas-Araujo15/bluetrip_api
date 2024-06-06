package com.api.bluetrip.controllers.dtos.booking;

import com.api.bluetrip.models.Booking;

import java.time.LocalDateTime;

public record BookingListDTO(
        Long id,
        LocalDateTime dateBooking
) {
    public BookingListDTO(Booking booking) {
        this(booking.getId(), booking.getDateBooking());
    }
}
