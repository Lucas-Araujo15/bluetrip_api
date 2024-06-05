package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.controllers.dtos.address.DetailedAddressDTO;
import com.api.bluetrip.controllers.dtos.user.DetailedUserDTO;
import com.api.bluetrip.models.LocalBusiness;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record DetailedLocalBusinessDTO(
        String tradeName,

        String description,

        String urlWebsite,

        String urlImage,

        LocalTime openHour,

        LocalTime closeHour,

        String phone,

        String businessCategory,

        DetailedUserDTO user,

        DetailedAddressDTO address

) {
    public DetailedLocalBusinessDTO(LocalBusiness localBusiness) {
        this(localBusiness.getTradeName(), localBusiness.getDescription(), localBusiness.getUrlWebsite(), localBusiness.getUrlImage(), localBusiness.getOpenHour(),
                localBusiness.getCloseHour(), localBusiness.getPhone(), localBusiness.getBusinessCategory(), new DetailedUserDTO(localBusiness.getUser()), new DetailedAddressDTO(localBusiness.getAddress()));
    }
}
