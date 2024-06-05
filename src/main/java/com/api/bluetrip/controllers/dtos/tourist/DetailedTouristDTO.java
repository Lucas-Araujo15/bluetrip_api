package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.controllers.dtos.user.DetailedUserDTO;
import com.api.bluetrip.models.Tourist;

import java.time.LocalDate;

public record DetailedTouristDTO(
        String name,

        String nationality,

        String phone,

        LocalDate dateOfBirth,

        String gender,

        String language,

        DetailedUserDTO user
) {
    public DetailedTouristDTO(Tourist tourist) {

        this(tourist.getName(), tourist.getNationality(), tourist.getPhone(), tourist.getDateOfBirth(), tourist.getGender(), tourist.getLanguage(), new DetailedUserDTO(tourist.getUser()));
    }
}
