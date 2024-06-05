package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.event.DetailedEventDTO;
import com.api.bluetrip.controllers.dtos.service.DetailedServiceDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceListDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceRegisterDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceUpdateDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotListDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotRegisterDTO;
import com.api.bluetrip.models.Event;
import com.api.bluetrip.models.TouristSpot;
import com.api.bluetrip.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceListDTO create(ServiceRegisterDTO serviceRegisterDTO) {
        return new ServiceListDTO(serviceRepository.save(new com.api.bluetrip.models.Service(serviceRegisterDTO)));
    }

    public DetailedServiceDTO findById(Long id) {
        return new DetailedServiceDTO(serviceRepository.getReferenceById(id));
    }

    public DetailedServiceDTO update(Long id, ServiceUpdateDTO serviceUpdateDTO) {
        com.api.bluetrip.models.Service service = serviceRepository.getReferenceById(id);

        service.updateInformation(serviceUpdateDTO);

        serviceRepository.save(service);

        return new DetailedServiceDTO(service);
    }

    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }
}
