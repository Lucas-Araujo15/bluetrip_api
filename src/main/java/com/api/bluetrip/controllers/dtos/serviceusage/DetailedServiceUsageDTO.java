package com.api.bluetrip.controllers.dtos.serviceusage;

import com.api.bluetrip.models.ServiceUsage;

import java.time.LocalDateTime;

public record DetailedServiceUsageDTO(
        LocalDateTime dateUsage,

        float rate,

        String comment
) {
    public DetailedServiceUsageDTO(ServiceUsage serviceUsage) {
        this(serviceUsage.getDateUsage(), serviceUsage.getRate(), serviceUsage.getComment());
    }
}
