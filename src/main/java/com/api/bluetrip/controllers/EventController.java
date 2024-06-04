package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.event.DetailedEventDTO;
import com.api.bluetrip.controllers.dtos.event.EventListDTO;
import com.api.bluetrip.controllers.dtos.event.EventRegisterDTO;
import com.api.bluetrip.controllers.dtos.event.EventUpdateDTO;
import com.api.bluetrip.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<EventListDTO>> create(@RequestBody @Valid EventRegisterDTO eventRegisterDTO) {
        EventListDTO eventListDTO = eventService.create(eventRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(EventController.class).findById(eventListDTO.id())).toUri())
                .body(EntityModel.of(eventListDTO,
                        linkTo(methodOn(EventController.class).findById(eventListDTO.id())).withSelfRel(),
                        linkTo(methodOn(EventController.class).find(null)).withRel("events")));
    }

    @GetMapping
    public ResponseEntity<Page<EventListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<EventListDTO> page = eventService.find(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedEventDTO> findById(@PathVariable("id") Long id) {
        DetailedEventDTO detailedEventDTO = eventService.findById(id);
        return ResponseEntity.ok(detailedEventDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedEventDTO> update(@RequestBody @Valid EventUpdateDTO eventUpdateDTO, @PathVariable("id") Long id) {
        DetailedEventDTO detailedEventDTO = EventService.update(id, eventUpdateDTO);
        return ResponseEntity.ok(detailedEventDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas")
    public CollectionModel<EntityModel<EventListDTO>> findAllEventssHateoas(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        List<EntityModel<EventListDTO>> events = eventService.find(pagination).stream()
                .map(event -> EntityModel.of(event,
                        linkTo(methodOn(EventController.class).findById(event.id())).withSelfRel()))
                .toList();

        return CollectionModel.of(events, linkTo(methodOn(EventController.class).find(null)).withSelfRel());
    }
}
