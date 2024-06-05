package com.api.bluetrip.controllers.dtos.service;

public record ServiceUpdateDTO(
        String name,

        String description,

        float price,

        String category
) {
}
