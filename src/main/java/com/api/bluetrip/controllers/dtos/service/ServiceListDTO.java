package com.api.bluetrip.controllers.dtos.service;

import com.api.bluetrip.models.Service;

public record ServiceListDTO(
        Long id,
        String name,
        String description
) {
    public ServiceListDTO(Service service) {
        this(service.getId(), service.getName(), service.getDescription());
    }
}
