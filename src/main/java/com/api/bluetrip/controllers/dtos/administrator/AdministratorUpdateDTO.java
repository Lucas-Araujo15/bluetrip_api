package com.api.bluetrip.controllers.dtos.administrator;

import com.api.bluetrip.controllers.dtos.user.UserUpdateDTO;

public record AdministratorUpdateDTO(
        String name,

        String phone,

        String role,

        UserUpdateDTO user
) {
}
