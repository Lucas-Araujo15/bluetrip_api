package com.api.bluetrip.controllers.dtos.tourist;

import com.api.bluetrip.models.Tourist;

public record DetailedTouristDTO() {
    public DetailedTouristDTO(Tourist tourist) {
        this();
    }
}
