package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.administrator.AdministratorListDTO;
import com.api.bluetrip.controllers.dtos.administrator.AdministratorRegisterDTO;
import com.api.bluetrip.controllers.dtos.administrator.AdministratorUpdateDTO;
import com.api.bluetrip.controllers.dtos.administrator.DetailedAdministratorDTO;
import com.api.bluetrip.models.Administrator;
import com.api.bluetrip.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    private final AdministratorRepository administratorRepository;

    private final UserService userService;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository, UserService userService) {
        this.administratorRepository = administratorRepository;
        this.userService = userService;
    }

    public AdministratorListDTO create(AdministratorRegisterDTO administratorRegisterDTO) {
        return new AdministratorListDTO(administratorRepository.save(new Administrator(administratorRegisterDTO)));
    }

    public Page<AdministratorListDTO> find(Pageable pagination) {
        return administratorRepository.findAll(pagination).map(AdministratorListDTO::new);
    }

    public DetailedAdministratorDTO findById(Long id) {
        return new DetailedAdministratorDTO(administratorRepository.getReferenceById(id));
    }

    public DetailedAdministratorDTO update(Long id, AdministratorUpdateDTO administratorUpdateDTO) {
        Administrator administrator = administratorRepository.getReferenceById(id);

        administrator.updateInformation(administratorUpdateDTO);

        userService.update(administrator.getUser().getId(), administratorUpdateDTO.user());

        administratorRepository.save(administrator);

        return new DetailedAdministratorDTO(administrator);
    }

    public void delete(Long id) {
        administratorRepository.deleteById(id);
    }
}
