package com.api.bluetrip.controllers.dtos.address;

import jakarta.validation.constraints.NotBlank;

public record AddressRegisterDTO(
        @NotBlank
        String street,

        @NotBlank
        String city,

        @NotBlank
        String zipCode,

        @NotBlank
        String state,

        @NotBlank
        String neighborhood,

        String numberBuilding,
        String complement
) { }
