package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "T_BT_EVENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_event", nullable = false)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "vl_price", nullable = false)
    private float price;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "dt_start", nullable = false)
    private LocalDateTime dateStart;

    @Column(name = "dt_end", nullable = true)
    private LocalDateTime dateEnd;
}
