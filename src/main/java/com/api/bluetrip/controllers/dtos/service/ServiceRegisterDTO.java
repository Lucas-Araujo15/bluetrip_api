package com.api.bluetrip.controllers.dtos.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        float price,

        @NotBlank
        String category
) {
}
