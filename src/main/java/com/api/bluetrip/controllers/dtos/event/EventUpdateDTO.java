package com.api.bluetrip.controllers.dtos.event;

import java.time.LocalDateTime;

public record EventUpdateDTO(
        String name,

        String description,

        float price,

        String urlImage,

        LocalDateTime dateStart,

        LocalDateTime dateEnd

        ) {
}
