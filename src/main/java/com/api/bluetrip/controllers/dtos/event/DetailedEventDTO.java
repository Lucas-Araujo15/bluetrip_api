package com.api.bluetrip.controllers.dtos.event;

import com.api.bluetrip.models.Event;

import java.time.LocalDateTime;

public record DetailedEventDTO(
        String name,

        String description,

        float price,

        String urlImage,

        LocalDateTime dateStart,

        LocalDateTime dateEnd
) {
    public DetailedEventDTO(Event event) {
        this(event.getName(), event.getDescription(), event.getPrice(), event.getUrlImage(), event.getDateStart(), event.getDateEnd());
    }
}
