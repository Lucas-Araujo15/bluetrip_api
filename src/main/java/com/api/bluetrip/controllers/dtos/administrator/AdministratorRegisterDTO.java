package com.api.bluetrip.controllers.dtos.administrator;

import com.api.bluetrip.controllers.dtos.UserRegisterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AdministratorRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String phone,

        @NotBlank
        String role,

        @Valid
        UserRegisterDTO user
) {
}
