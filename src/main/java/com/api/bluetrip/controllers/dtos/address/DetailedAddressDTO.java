package com.api.bluetrip.controllers.dtos.address;

import com.api.bluetrip.models.Address;
import jakarta.validation.constraints.NotBlank;

public record DetailedAddressDTO(
        String street,

        String city,

        String zipCode,

        String state,

        String neighborhood,

        String numberBuilding,
        String complement
) {
    public DetailedAddressDTO(Address address) {
        this(address.getStreet(), address.getCity(), address.getZipCode(), address.getState(), address.getNeighborhood(), address.getNumberBuilding(), address.getComplement());
    }
}
