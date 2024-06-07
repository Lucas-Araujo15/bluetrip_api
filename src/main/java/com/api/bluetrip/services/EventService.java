package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.event.DetailedEventDTO;
import com.api.bluetrip.controllers.dtos.event.EventListDTO;
import com.api.bluetrip.controllers.dtos.event.EventRegisterDTO;
import com.api.bluetrip.controllers.dtos.event.EventUpdateDTO;
import com.api.bluetrip.models.Event;
import com.api.bluetrip.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    private final TouristSpotService touristSpotService;

    @Autowired
    public EventService(EventRepository eventRepository, TouristSpotService touristSpotService) {
        this.eventRepository = eventRepository;
        this.touristSpotService = touristSpotService;
    }

    public EventListDTO create(EventRegisterDTO eventRegisterDTO) {
        Event event = new Event(eventRegisterDTO);

        event.setTouristSpot(touristSpotService.get(eventRegisterDTO.touristSpotId()));

        return new EventListDTO(eventRepository.save(new Event(eventRegisterDTO)));
    }

    public Page<EventListDTO> find(Pageable pagination) {
        return eventRepository.findAll(pagination).map(EventListDTO::new);
    }

    public DetailedEventDTO findById(Long id) {
        return new DetailedEventDTO(eventRepository.getReferenceById(id));
    }

    public DetailedEventDTO update(Long id, EventUpdateDTO eventUpdateDTO) {
        Event event = eventRepository.getReferenceById(id);

        event.updateInformation(eventUpdateDTO);

        eventRepository.save(event);

        return new DetailedEventDTO(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
