package com.api.bluetrip.services;

import com.api.bluetrip.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }
}
