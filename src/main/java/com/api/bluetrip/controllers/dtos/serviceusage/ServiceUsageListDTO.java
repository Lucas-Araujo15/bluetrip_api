package com.api.bluetrip.controllers.dtos.serviceusage;

import com.api.bluetrip.models.ServiceUsage;

import java.time.LocalDateTime;

public record ServiceUsageListDTO(
        Long id,
        LocalDateTime dateUsage
) {
    public ServiceUsageListDTO(ServiceUsage serviceUsage) {
        this(serviceUsage.getId(), serviceUsage.getDateUsage());
    }
}
