package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.booking.DetailedBookingDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.DetailedServiceUsageDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.ServiceUsageListDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.ServiceUsageRegisterDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristListDTO;
import com.api.bluetrip.models.ServiceUsage;
import com.api.bluetrip.repositories.ServiceUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsageService {
    private final ServiceUsageRepository serviceUsageRepository;

    private final ServiceService serviceService;

    private final TouristService touristService;

    @Autowired
    public ServiceUsageService(ServiceUsageRepository serviceUsageRepository, ServiceService serviceService, TouristService touristService) {
        this.serviceUsageRepository = serviceUsageRepository;
        this.serviceService = serviceService;
        this.touristService = touristService;
    }

    public ServiceUsageListDTO create(ServiceUsageRegisterDTO serviceUsageRegisterDTO) {
        ServiceUsage serviceUsage = new ServiceUsage(serviceUsageRegisterDTO);

        serviceUsage.setService(serviceService.get(serviceUsageRegisterDTO.serviceId()));

        serviceUsage.setTourist(touristService.get(serviceUsageRegisterDTO.touristId()));

        serviceUsageRepository.save(serviceUsage);

        return new ServiceUsageListDTO(serviceUsage);
    }

    public Page<ServiceUsageListDTO> find(Pageable pagination) {
        return serviceUsageRepository.findAll(pagination).map(ServiceUsageListDTO::new);
    }

    public DetailedServiceUsageDTO findById(Long id) {
        return new DetailedServiceUsageDTO(serviceUsageRepository.getReferenceById(id));
    }
 }
