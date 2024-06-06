package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.booking.BookingListDTO;
import com.api.bluetrip.controllers.dtos.booking.BookingRegisterDTO;
import com.api.bluetrip.controllers.dtos.booking.DetailedBookingDTO;
import com.api.bluetrip.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<BookingListDTO>> create(@RequestBody @Valid BookingRegisterDTO bookingRegisterDTO) {
        BookingListDTO bookingListDTO = bookingService.create(bookingRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(BookingController.class).findById(bookingListDTO.id())).toUri())
                .body(EntityModel.of(bookingListDTO,
                        linkTo(methodOn(BookingController.class).findById(bookingListDTO.id())).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedBookingDTO> findById(@PathVariable("id") Long id) {
        DetailedBookingDTO detailedBookingDTO = bookingService.findById(id);
        return ResponseEntity.ok(detailedBookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
