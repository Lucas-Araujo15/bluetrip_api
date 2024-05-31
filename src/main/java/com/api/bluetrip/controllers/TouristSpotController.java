package com.api.bluetrip.controllers;

import com.api.bluetrip.services.TouristSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tourist-controller")
public class TouristSpotController {
    private final TouristSpotService touristSpotService;

    @Autowired
    public TouristSpotController(TouristSpotService touristSpotService) {
        this.touristSpotService = touristSpotService;
    }
}
