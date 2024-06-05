package com.api.bluetrip.controllers.dtos.touristspot;

import com.api.bluetrip.controllers.dtos.address.DetailedAddressDTO;
import com.api.bluetrip.controllers.dtos.event.DetailedEventDTO;
import com.api.bluetrip.models.TouristSpot;

import java.util.List;

public record DetailedTouristSpotDTO(
        String name,

        String description,

        float averageRate,

        float price,

        String phone,

        String urlImage,

        String category,

        DetailedAddressDTO address,

        List<DetailedEventDTO> events
        )
{
    public DetailedTouristSpotDTO(TouristSpot touristSpot) {
        this(touristSpot.getName(), touristSpot.getDescription(), touristSpot.getAverageRate(), touristSpot.getPrice(),
                touristSpot.getPhone(), touristSpot.getUrlImage(), touristSpot.getCategory(), new DetailedAddressDTO(touristSpot.getAddress()),
                touristSpot.getEventList().stream().map(DetailedEventDTO::new).toList());
    }
}
