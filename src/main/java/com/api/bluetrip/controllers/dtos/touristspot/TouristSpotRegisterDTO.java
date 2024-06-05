package com.api.bluetrip.controllers.dtos.touristspot;

import com.api.bluetrip.controllers.dtos.address.AddressRegisterDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TouristSpotRegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        float averageRate,

        @NotNull
        float price,

        @NotBlank
        String phone,

        @NotBlank
        String urlImage,

        @NotBlank
        String category,

        @Valid
        AddressRegisterDTO address
) {
}
