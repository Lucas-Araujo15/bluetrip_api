package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.touristspot.DetailedTouristSpotDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotListDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotRegisterDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotUpdateDTO;
import com.api.bluetrip.models.TouristSpot;
import com.api.bluetrip.repositories.TouristSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TouristSpotService {
    private final TouristSpotRepository touristSpotRepository;

    private final AddressService addressService;

    @Autowired
    public TouristSpotService(TouristSpotRepository touristSpotRepository, AddressService addressService) {
        this.touristSpotRepository = touristSpotRepository;
        this.addressService = addressService;
    }

    public TouristSpotListDTO create(TouristSpotRegisterDTO touristSpotRegisterDTO) {
        return new TouristSpotListDTO(touristSpotRepository.save(new TouristSpot(touristSpotRegisterDTO)));
    }

    public Page<TouristSpotListDTO> find(Pageable pagination) {
        return touristSpotRepository.findAll(pagination).map(TouristSpotListDTO::new);
    }

    public DetailedTouristSpotDTO findById(Long id) {
        return new DetailedTouristSpotDTO(touristSpotRepository.getReferenceById(id));
    }

    public DetailedTouristSpotDTO update(Long id, TouristSpotUpdateDTO touristSpotUpdateDTO) {
        TouristSpot touristSpot = touristSpotRepository.getReferenceById(id);

        touristSpot.updateInformation(touristSpotUpdateDTO);

        addressService.update(touristSpot.getAddress().getId(), touristSpotUpdateDTO.address());

        touristSpotRepository.save(touristSpot);

        return new DetailedTouristSpotDTO(touristSpot);
    }

    public void delete(Long id) {
        touristSpotRepository.deleteById(id);
    }

    public TouristSpot get(Long id) {
        return touristSpotRepository.getReferenceById(id);
    }
}
