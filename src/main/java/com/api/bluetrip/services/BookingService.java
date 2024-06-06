package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.booking.BookingListDTO;
import com.api.bluetrip.controllers.dtos.booking.BookingRegisterDTO;
import com.api.bluetrip.controllers.dtos.booking.DetailedBookingDTO;
import com.api.bluetrip.models.Booking;
import com.api.bluetrip.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    private final TouristService touristService;

    private final TouristSpotService touristSpotService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, TouristService touristService, TouristSpotService touristSpotService) {
        this.bookingRepository = bookingRepository;
        this.touristService = touristService;
        this.touristSpotService = touristSpotService;
    }

    public BookingListDTO create(BookingRegisterDTO bookingRegisterDTO) {
        Booking booking = new Booking(bookingRegisterDTO);

        booking.setTourist(touristService.get(bookingRegisterDTO.touristId()));

        booking.setTouristSpot(touristSpotService.get(bookingRegisterDTO.touristSpotId()));

        bookingRepository.save(booking);

        return new BookingListDTO(booking);
    }

    public DetailedBookingDTO findById(Long id) {
        return new DetailedBookingDTO(bookingRepository.getReferenceById(id));
    }

    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
