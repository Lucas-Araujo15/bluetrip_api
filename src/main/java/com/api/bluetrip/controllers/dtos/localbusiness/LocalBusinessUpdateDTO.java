package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.controllers.dtos.address.AddressUpdateDTO;
import com.api.bluetrip.controllers.dtos.user.UserUpdateDTO;

import java.time.LocalDateTime;

public record LocalBusinessUpdateDTO(
        String tradeName,

        String description,

        String urlWebsite,

        String urlImage,

        LocalDateTime openHour,

        LocalDateTime closeHour,

        String phone,

        String businessCategory,

        AddressUpdateDTO address,

        UserUpdateDTO user
) {

}
