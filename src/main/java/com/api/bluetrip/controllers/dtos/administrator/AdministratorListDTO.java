package com.api.bluetrip.controllers.dtos.administrator;

import com.api.bluetrip.models.Administrator;

public record AdministratorListDTO(
        Long id,
        String name
) {
    public AdministratorListDTO(Administrator administrator) {
        this(administrator.getId(), administrator.getName());
    }
}
