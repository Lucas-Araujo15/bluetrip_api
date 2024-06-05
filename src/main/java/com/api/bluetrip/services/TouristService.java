package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.tourist.DetailedTouristDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristListDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristRegisterDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristUpdateDTO;
import com.api.bluetrip.models.Tourist;
import com.api.bluetrip.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public TouristListDTO create(TouristRegisterDTO touristRegisterDTO) {
        return new TouristListDTO(touristRepository.save(new Tourist(touristRegisterDTO)));
    }

    public Page<TouristListDTO> find(Pageable pagination) {
        return touristRepository.findAll(pagination).map(TouristListDTO::new);
    }

    public DetailedTouristDTO findById(Long id) {
        return new DetailedTouristDTO(touristRepository.getReferenceById(id));
    }

    public DetailedTouristDTO update(Long id, TouristUpdateDTO touristUpdateDTO) {
        Tourist tourist = touristRepository.getReferenceById(id);

        tourist.updateInformation(touristUpdateDTO);

        touristRepository.save(tourist);

        return new DetailedTouristDTO(tourist);
    }

    public void delete(Long id) {
        touristRepository.deleteById(id);
    }

}
