package com.api.bluetrip.controllers.dtos.service;

import com.api.bluetrip.models.Service;

public record DetailedServiceDTO(
        String name,

        String description,

        float price,

        String category
) {
    public DetailedServiceDTO(Service service) {
        this(service.getName(), service.getDescription(), service.getPrice(), service.getCategory());
    }
}
