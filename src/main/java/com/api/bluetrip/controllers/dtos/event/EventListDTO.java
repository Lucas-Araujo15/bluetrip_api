package com.api.bluetrip.controllers.dtos.event;

import com.api.bluetrip.models.Event;

public record EventListDTO(
        Long id,
        String name,
        String description
) {
    public EventListDTO(Event event) {
        this(event.getId(), event.getName(), event.getDescription());
    }
}
