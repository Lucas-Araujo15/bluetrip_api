package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.models.Tourist;

public record TouristListDTO(
        Long id,

        String name,

        String phone
) {
    public TouristListDTO(Tourist tourist) {
        this(tourist.getId(), tourist.getName(), tourist.getPhone());
    }
}
