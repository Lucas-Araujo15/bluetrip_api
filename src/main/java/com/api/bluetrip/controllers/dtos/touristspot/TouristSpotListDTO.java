package com.api.bluetrip.controllers.dtos.touristspot;

import com.api.bluetrip.models.TouristSpot;

public record TouristSpotListDTO(
        Long id,
        String name,
        String description
) {
    public TouristSpotListDTO(TouristSpot touristSpot) {
        this(touristSpot.getId(), touristSpot.getName(), touristSpot.getDescription());
    }
}
