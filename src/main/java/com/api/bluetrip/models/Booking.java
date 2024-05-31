package com.api.bluetrip.models;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking", nullable = false)
    private Long id;

    @Column(name = "dt_booking", nullable = false)
    private LocalDateTime dateBooking;

    @Column(name = "st_booking", nullable = false)
    private String statusBooking;

    @Column(name = "nr_quantity", nullable = false)
    private int quantity;
}
