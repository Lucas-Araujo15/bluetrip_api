package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.controllers.dtos.user.UserRegisterDTO;
import com.api.bluetrip.controllers.dtos.address.AddressRegisterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record LocalBusinessRegisterDTO(
        @NotBlank
        String tradeName,

        @NotBlank
        String description,

        @NotBlank
        String urlWebsite,

        @NotBlank
        String urlImage,

        @NotNull
        LocalDateTime openHour,

        @NotNull
        LocalDateTime closeHour,

        @NotBlank
        String phone,

        @NotBlank
        String businessCategory,

        @Valid
        UserRegisterDTO user,
        AddressRegisterDTO address
) {
}
