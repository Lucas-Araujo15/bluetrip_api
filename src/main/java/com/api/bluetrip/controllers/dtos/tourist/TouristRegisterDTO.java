package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.controllers.dtos.UserRegisterDTO;
import com.api.bluetrip.models.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TouristRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String nationality,

        @NotBlank
        String phone,

        @NotNull
        LocalDate dateOfBirth,

        @NotBlank
        String gender,

        @NotBlank
        String language,

        @NotNull
        @Valid
        UserRegisterDTO user
) {
}
