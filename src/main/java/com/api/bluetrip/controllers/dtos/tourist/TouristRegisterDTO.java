package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.controllers.dtos.user.UserRegisterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record TouristRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String nationality,

        @NotBlank
        String phone,

        @NotNull
        @Past
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
