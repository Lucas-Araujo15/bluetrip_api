package com.api.bluetrip.controllers;

import com.api.bluetrip.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }
}
