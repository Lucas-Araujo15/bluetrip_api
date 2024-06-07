package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.controllers.dtos.booking.DetailedBookingDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.DetailedServiceUsageDTO;
import com.api.bluetrip.controllers.dtos.user.DetailedUserDTO;
import com.api.bluetrip.models.Tourist;

import java.time.LocalDate;
import java.util.List;

public record DetailedTouristDTO(
        String name,

        String nationality,

        String phone,

        LocalDate dateOfBirth,

        String gender,

        String language,

        DetailedUserDTO user,

        List<DetailedServiceUsageDTO> serviceUsages,

        List<DetailedBookingDTO> bookingList
) {
    public DetailedTouristDTO(Tourist tourist) {

        this(tourist.getName(), tourist.getNationality(), tourist.getPhone(), tourist.getDateOfBirth(), tourist.getGender(), tourist.getLanguage(), new DetailedUserDTO(tourist.getUser()),
                tourist.getServiceUsageList().stream().map(DetailedServiceUsageDTO::new).toList(),
                tourist.getBookingList().stream().map(DetailedBookingDTO::new).toList());
    }
}
