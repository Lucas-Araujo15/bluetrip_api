package com.api.bluetrip.controllers.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDTO(
        @Email
        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        String userType
) {
}
