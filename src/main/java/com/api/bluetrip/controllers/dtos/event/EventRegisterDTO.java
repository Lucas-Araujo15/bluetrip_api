package com.api.bluetrip.controllers.dtos.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        float price,

        @NotBlank
        String urlImage,

        @NotNull
        LocalDateTime dateStart,

        @NotNull
        LocalDateTime dateEnd,

        @NotNull
        Long touristSpotId
) {
}
