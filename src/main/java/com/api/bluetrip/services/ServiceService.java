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

    private final LocalBusinessService localBusinessService;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, LocalBusinessService localBusinessService) {
        this.serviceRepository = serviceRepository;
        this.localBusinessService = localBusinessService;
    }

    public ServiceListDTO create(ServiceRegisterDTO serviceRegisterDTO) {
        com.api.bluetrip.models.Service service = new com.api.bluetrip.models.Service(serviceRegisterDTO);

        service.setLocalBusiness(localBusinessService.get(serviceRegisterDTO.localBusinessId()));

        serviceRepository.save(service);

        return new ServiceListDTO(service);
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

    public com.api.bluetrip.models.Service get(Long id) {
        return serviceRepository.getReferenceById(id);
    }
}
