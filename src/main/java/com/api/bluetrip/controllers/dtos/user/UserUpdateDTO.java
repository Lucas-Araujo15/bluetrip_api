package com.api.bluetrip.controllers.dtos.user;

import jakarta.validation.constraints.Email;

public record UserUpdateDTO(
        @Email
        String email,
        String password
) {
}
