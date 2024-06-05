package com.api.bluetrip.controllers.dtos.administrator;

import com.api.bluetrip.controllers.dtos.user.DetailedUserDTO;
import com.api.bluetrip.models.Administrator;

public record DetailedAdministratorDTO(
        String name,
        String phone,
        String role,
        DetailedUserDTO user
) {
    public DetailedAdministratorDTO(Administrator administrator) {
        this(administrator.getName(), administrator.getPhone(), administrator.getRole(), new DetailedUserDTO(administrator.getUser()));
    }
}
