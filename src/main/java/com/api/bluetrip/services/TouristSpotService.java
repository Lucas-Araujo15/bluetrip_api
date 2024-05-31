package com.api.bluetrip.services;

import com.api.bluetrip.repositories.TouristSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristSpotService {
    private final TouristSpotRepository touristSpotRepository;

    @Autowired
    public TouristSpotService(TouristSpotRepository touristSpotRepository) {
        this.touristSpotRepository = touristSpotRepository;
    }
}
