package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.address.AddressUpdateDTO;
import com.api.bluetrip.models.Address;
import com.api.bluetrip.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void update(Long id, AddressUpdateDTO addressUpdateDTO) {
        Address address = addressRepository.getReferenceById(id);

        address.updateInformation(addressUpdateDTO);

        addressRepository.save(address);
    }
}
