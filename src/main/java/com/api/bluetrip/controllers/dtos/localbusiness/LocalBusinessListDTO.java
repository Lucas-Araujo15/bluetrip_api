package com.api.bluetrip.controllers.dtos.localbusiness;

import com.api.bluetrip.models.LocalBusiness;

public record LocalBusinessListDTO(
        Long id,
        String tradeName,
        String description,
        String urlImage
) {
    public LocalBusinessListDTO(LocalBusiness localBusiness) {
        this(localBusiness.getId(), localBusiness.getTradeName(), localBusiness.getDescription(), localBusiness.getUrlImage());
    }
}
