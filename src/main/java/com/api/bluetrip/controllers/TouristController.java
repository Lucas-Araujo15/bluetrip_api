package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.tourist.DetailedTouristDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristListDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristRegisterDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristUpdateDTO;
import com.api.bluetrip.services.TouristService;
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
@RequestMapping("/api/tourist")
public class TouristController {
    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<TouristListDTO>> create(@RequestBody @Valid TouristRegisterDTO touristRegisterDTO) {
        TouristListDTO touristListDTO = touristService.create(touristRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(TouristController.class).findById(touristListDTO.id())).toUri())
                .body(EntityModel.of(touristListDTO,
                        linkTo(methodOn(TouristController.class).findById(touristListDTO.id())).withSelfRel(),
                        linkTo(methodOn(TouristController.class).find(null)).withRel("tourists")));
    }

    @GetMapping
    public ResponseEntity<Page<TouristListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<TouristListDTO> page = touristService.find(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTouristDTO> findById(@PathVariable("id") Long id) {
        DetailedTouristDTO detailedTouristDTO = touristService.findById(id);
        return ResponseEntity.ok(detailedTouristDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedTouristDTO> update(@RequestBody @Valid TouristUpdateDTO touristUpdateDTO, @PathVariable("id") Long id) {
        DetailedTouristDTO detailedTouristDTO = touristService.update(id, touristUpdateDTO);
        return ResponseEntity.ok(detailedTouristDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        touristService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas")
    public CollectionModel<EntityModel<TouristListDTO>> findAllTouristsHateoas(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        List<EntityModel<TouristListDTO>> tourists = touristService.find(pagination).stream()
                .map(tourist -> EntityModel.of(tourist,
                        linkTo(methodOn(TouristController.class).findById(tourist.id())).withSelfRel()))
                .toList();

        return CollectionModel.of(tourists, linkTo(methodOn(TouristController.class).find(null)).withSelfRel());
    }
}
