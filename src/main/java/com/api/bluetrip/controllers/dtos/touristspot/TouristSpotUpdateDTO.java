package com.api.bluetrip.controllers.dtos.touristspot;

import com.api.bluetrip.controllers.dtos.address.AddressUpdateDTO;

public record TouristSpotUpdateDTO(
        String name,

        String description,

        float averageRate,

        float price,

        String phone,

        String urlImage,

        String category,

        AddressUpdateDTO address
) {
}
