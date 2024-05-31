package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
