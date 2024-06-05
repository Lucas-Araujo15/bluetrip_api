package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.controllers.dtos.address.AddressUpdateDTO;
import com.api.bluetrip.controllers.dtos.user.UserUpdateDTO;

import java.time.LocalTime;

public record LocalBusinessUpdateDTO(
        String tradeName,

        String description,

        String urlWebsite,

        String urlImage,

        LocalTime openHour,

        LocalTime closeHour,

        String phone,

        String businessCategory,

        AddressUpdateDTO address,

        UserUpdateDTO user
) {

}
