package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.booking.BookingRegisterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "T_BT_BOOKING")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqBooking")
    @SequenceGenerator(name = "seqBooking", sequenceName = "SEQ_T_BT_BOOKING", allocationSize = 1)
    @Column(name = "id_booking", nullable = false)
    private Long id;

    @Column(name = "dt_booking", nullable = false)
    private LocalDateTime dateBooking;

    @Column(name = "st_booking", nullable = false)
    private String statusBooking;

    @Column(name = "nr_quantity", nullable = false)
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_tourist_id_tourist")
    private Tourist tourist;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_tourist_spot_id_tourist_spot")
    private TouristSpot touristSpot;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_payment_id_payment")
    private Payment payment;

    public Booking(BookingRegisterDTO bookingRegisterDTO) {
        this.dateBooking = bookingRegisterDTO.dateBooking();
        this.quantity = bookingRegisterDTO.quantity();
        this.payment = new Payment(bookingRegisterDTO.payment());
    }
}
