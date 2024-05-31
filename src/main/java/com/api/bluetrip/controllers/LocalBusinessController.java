package com.api.bluetrip.controllers;

import com.api.bluetrip.services.LocalBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/local-business")
public class LocalBusinessController {
    private final LocalBusinessService localBusinessService;

    @Autowired
    public LocalBusinessController(LocalBusinessService localBusinessService) {
        this.localBusinessService = localBusinessService;
    }
}
