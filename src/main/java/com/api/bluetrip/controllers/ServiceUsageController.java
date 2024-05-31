package com.api.bluetrip.controllers;

import com.api.bluetrip.services.ServiceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service-usage")
public class ServiceUsageController {
    private final ServiceUsageService serviceUsageService;

    @Autowired
    public ServiceUsageController(ServiceUsageService serviceUsageService) {
        this.serviceUsageService = serviceUsageService;
    }
 }
