package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.event.EventRegisterDTO;
import com.api.bluetrip.controllers.dtos.event.EventUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "T_BT_EVENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "t_bt_tourist_spot_id_tourist_spot")
    private TouristSpot touristSpot;

    public Event(EventRegisterDTO eventRegisterDTO) {
        this.name = eventRegisterDTO.name();
        this.description = eventRegisterDTO.description();
        this.price = eventRegisterDTO.price();
        this.urlImage = eventRegisterDTO.urlImage();
        this.dateStart = eventRegisterDTO.dateStart();
        this.dateEnd = eventRegisterDTO.dateEnd();
    }

    public void updateInformation(EventUpdateDTO eventUpdateDTO) {
        if (eventUpdateDTO.name() != null) {
            this.name = eventUpdateDTO.name();
        }

        if (eventUpdateDTO.description() != null) {
            this.description = eventUpdateDTO.description();
        }

        if (eventUpdateDTO.price() != 0.0f) {
            this.price = eventUpdateDTO.price();
        }

        if (eventUpdateDTO.urlImage() != null) {
            this.urlImage = eventUpdateDTO.urlImage();
        }

        if (eventUpdateDTO.dateStart() != null) {
            this.dateStart = eventUpdateDTO.dateStart();
        }

        if (eventUpdateDTO.dateEnd() != null) {
            this.dateEnd = eventUpdateDTO.dateEnd();
        }
    }
}
