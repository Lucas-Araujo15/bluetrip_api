package com.api.bluetrip.controllers.dtos.address;

public record AddressUpdateDTO(
        String street,

        String city,

        String zipCode,

        String state,

        String neighborhood,

        String numberBuilding,

        String complement
) {
}
