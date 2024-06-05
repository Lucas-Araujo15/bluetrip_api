package com.api.bluetrip.controllers.dtos.tourist;

import java.time.LocalDate;

public record TouristUpdateDTO(
        String name,

        String nationality,

        String phone,

        LocalDate dateOfBirth,

        String gender,

        String language
) {
}
