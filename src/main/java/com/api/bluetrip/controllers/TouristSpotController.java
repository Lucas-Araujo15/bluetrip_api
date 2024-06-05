package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.touristspot.DetailedTouristSpotDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotListDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotRegisterDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotUpdateDTO;
import com.api.bluetrip.services.TouristSpotService;
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
@RequestMapping("/api/tourist-controller")
public class TouristSpotController {
    private final TouristSpotService touristSpotService;

    @Autowired
    public TouristSpotController(TouristSpotService touristSpotService) {
        this.touristSpotService = touristSpotService;
    }

//    @PostMapping
//    public ResponseEntity<EntityModel<TouristSpotListDTO>> create(@RequestBody @Valid TouristSpotRegisterDTO touristSpotRegisterDTO) {
//        TouristSpotListDTO touristSpotListDTO = touristSpotService.create(touristSpotRegisterDTO);
//
//        return ResponseEntity
//                .created(linkTo(methodOn(TouristSpotController.class).findById(touristSpotListDTO.id())).toUri())
//                .body(EntityModel.of(touristSpotListDTO,
//                        linkTo(methodOn(TouristSpotController.class).findById(touristSpotListDTO.id())).withSelfRel(),
//                        linkTo(methodOn(TouristSpotController.class).find(null)).withRel("tourist-spots")));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<TouristSpotListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
//        Page<TouristSpotListDTO> page = touristSpotService.find(pagination);
//        return ResponseEntity.ok(page);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<DetailedTouristSpotDTO> findById(@PathVariable("id") Long id) {
//        DetailedTouristSpotDTO detailedTouristSpotDTO = touristSpotService.findById(id);
//        return ResponseEntity.ok(detailedTouristSpotDTO);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<DetailedTouristSpotDTO> update(@RequestBody @Valid TouristSpotUpdateDTO touristSpotUpdateDTO, @PathVariable("id") Long id) {
//        DetailedTouristSpotDTO detailedTouristSpotDTO = touristSpotService.update(id, touristSpotUpdateDTO);
//        return ResponseEntity.ok(detailedTouristSpotDTO);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
//        touristSpotService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/hateoas")
//    public CollectionModel<EntityModel<TouristSpotListDTO>> findAllTouristSpotsHateoas(@PageableDefault(size = 10, page = 0) Pageable pagination) {
//        List<EntityModel<TouristSpotListDTO>> touristSpots = touristSpotService.find(pagination).stream()
//                .map(touristSpot -> EntityModel.of(touristSpot,
//                        linkTo(methodOn(TouristSpotController.class).findById(touristSpot.id())).withSelfRel()))
//                .toList();
//
//        return CollectionModel.of(touristSpots, linkTo(methodOn(TouristSpotController.class).find(null)).withSelfRel());
//    }
}
