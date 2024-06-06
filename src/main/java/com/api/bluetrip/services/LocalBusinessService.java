package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.localbusiness.DetailedLocalBusinessDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessListDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessRegisterDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessUpdateDTO;
import com.api.bluetrip.models.LocalBusiness;
import com.api.bluetrip.repositories.LocalBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocalBusinessService {
    private final LocalBusinessRepository localBusinessRepository;

    private final AddressService addressService;

    private final UserService userService;

    @Autowired
    public LocalBusinessService(LocalBusinessRepository localBusinessRepository, AddressService addressService, UserService userService) {
        this.localBusinessRepository = localBusinessRepository;
        this.addressService = addressService;
        this.userService = userService;
    }

    public LocalBusinessListDTO create(LocalBusinessRegisterDTO localBusinessRegisterDTO) {
        return new LocalBusinessListDTO(localBusinessRepository.save(new LocalBusiness(localBusinessRegisterDTO)));
    }

    public Page<LocalBusinessListDTO> find(Pageable pagination) {
        return localBusinessRepository.findAll(pagination).map(LocalBusinessListDTO::new);
    }

    public DetailedLocalBusinessDTO findById(Long id) {
        return new DetailedLocalBusinessDTO(localBusinessRepository.getReferenceById(id));
    }

    public void delete(Long id) {
        localBusinessRepository.deleteById(id);
    }

    public DetailedLocalBusinessDTO update(Long id, LocalBusinessUpdateDTO localBusinessUpdateDTO) {
        LocalBusiness localBusiness = localBusinessRepository.getReferenceById(id);

        localBusiness.updateInformation(localBusinessUpdateDTO);

        if (localBusinessUpdateDTO.address() != null) {
            addressService.update(localBusiness.getAddress().getId(), localBusinessUpdateDTO.address());
        }

        if (localBusinessUpdateDTO.user() != null) {
            userService.update(localBusiness.getUser().getId(), localBusinessUpdateDTO.user());
        }

        localBusinessRepository.save(localBusiness);

        return new DetailedLocalBusinessDTO(localBusiness);
    }

    public LocalBusiness get(Long id) {
        return localBusinessRepository.getReferenceById(id);
    }
}
