package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.controllers.dtos.address.DetailedAddressDTO;
import com.api.bluetrip.controllers.dtos.service.DetailedServiceDTO;
import com.api.bluetrip.controllers.dtos.user.DetailedUserDTO;
import com.api.bluetrip.models.LocalBusiness;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record DetailedLocalBusinessDTO(
        String tradeName,

        String description,

        String urlWebsite,

        String urlImage,

        LocalDateTime openHour,

        LocalDateTime closeHour,

        String phone,

        String businessCategory,

        DetailedUserDTO user,

        DetailedAddressDTO address,

        List<DetailedServiceDTO> services

) {
    public DetailedLocalBusinessDTO(LocalBusiness localBusiness) {
        this(localBusiness.getTradeName(), localBusiness.getDescription(), localBusiness.getUrlWebsite(), localBusiness.getUrlImage(), localBusiness.getOpenHour(),
                localBusiness.getCloseHour(), localBusiness.getPhone(), localBusiness.getBusinessCategory(), new DetailedUserDTO(localBusiness.getUser()), new DetailedAddressDTO(localBusiness.getAddress()),
                localBusiness.getServiceList().stream().map(DetailedServiceDTO::new).toList());
    }
}
