package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.localbusiness.DetailedLocalBusinessDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessListDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessRegisterDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessUpdateDTO;
import com.api.bluetrip.services.LocalBusinessService;
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
@RequestMapping("/api/local-business")
public class LocalBusinessController {
    private final LocalBusinessService localBusinessService;

    @Autowired
    public LocalBusinessController(LocalBusinessService localBusinessService) {
        this.localBusinessService = localBusinessService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<LocalBusinessListDTO>> create(@RequestBody @Valid LocalBusinessRegisterDTO localBusinessRegisterDTO) {
        LocalBusinessListDTO localBusinessListDTO = localBusinessRegisterDTO.create(localBusinessRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(LocalBusinessController.class).findById(localBusinessListDTO.id())).toUri())
                .body(EntityModel.of(localBusinessListDTO,
                        linkTo(methodOn(LocalBusinessController.class).findById(localBusinessListDTO.id())).withSelfRel(),
                        linkTo(methodOn(LocalBusinessController.class).find(null)).withRel("local-businesses")));
    }

    @GetMapping
    public ResponseEntity<Page<LocalBusinessListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<LocalBusinessListDTO> page = localBusinessService.find(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedLocalBusinessDTO> findById(@PathVariable("id") Long id) {
        DetailedLocalBusinessDTO detailedLocalBusinessDTO = localBusinessService.findById(id);
        return ResponseEntity.ok(detailedLocalBusinessDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedLocalBusinessDTO> update(@RequestBody @Valid LocalBusinessUpdateDTO localBusinessUpdateDTO, @PathVariable("id") Long id) {
        DetailedLocalBusinessDTO detailedLocalBusinessDTO = localBusinessService.update(id, localBusinessUpdateDTO);
        return ResponseEntity.ok(detailedLocalBusinessDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        localBusinessService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas")
    public CollectionModel<EntityModel<LocalBusinessListDTO>> findAllLocalBusinessHateoas(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        List<EntityModel<LocalBusinessListDTO>> localBusinesses = localBusinessService.find(pagination).stream()
                .map(localBusiness -> EntityModel.of(localBusiness,
                        linkTo(methodOn(LocalBusinessController.class).findById(localBusiness.id())).withSelfRel()))
                .toList();

        return CollectionModel.of(localBusinesses, linkTo(methodOn(LocalBusinessController.class).find(null)).withSelfRel());
    }
}
