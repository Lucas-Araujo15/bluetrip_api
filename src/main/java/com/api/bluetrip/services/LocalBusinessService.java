package com.api.bluetrip.services;

import com.api.bluetrip.repositories.LocalBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalBusinessService {
    private final LocalBusinessRepository localBusinessRepository;

    @Autowired
    public LocalBusinessService(LocalBusinessRepository localBusinessRepository) {
        this.localBusinessRepository = localBusinessRepository;
    }
}
