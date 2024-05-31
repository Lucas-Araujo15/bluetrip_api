package com.api.bluetrip.services;

import com.api.bluetrip.repositories.ServiceUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsageService {
    private final ServiceUsageRepository serviceUsageRepository;

    @Autowired
    public ServiceUsageService(ServiceUsageRepository serviceUsageRepository) {
        this.serviceUsageRepository = serviceUsageRepository;
    }
 }
