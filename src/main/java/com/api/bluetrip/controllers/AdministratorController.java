package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.administrator.AdministratorListDTO;
import com.api.bluetrip.controllers.dtos.administrator.AdministratorRegisterDTO;
import com.api.bluetrip.controllers.dtos.administrator.AdministratorUpdateDTO;
import com.api.bluetrip.controllers.dtos.administrator.DetailedAdministratorDTO;
import com.api.bluetrip.services.AdministratorService;
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
@RequestMapping("/api/administrator")
public class AdministratorController {
    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<AdministratorListDTO>> create(@RequestBody @Valid AdministratorRegisterDTO administratorRegisterDTO) {
        AdministratorListDTO administratorListDTO = administratorService.create(administratorRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(AdministratorController.class).findById(administratorListDTO.id())).toUri())
                .body(EntityModel.of(administratorListDTO,
                        linkTo(methodOn(AdministratorController.class).findById(administratorListDTO.id())).withSelfRel(),
                        linkTo(methodOn(AdministratorController.class).find(null)).withRel("administrators")));
    }

    @GetMapping
    public ResponseEntity<Page<AdministratorListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<AdministratorListDTO> page = administratorService.find(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedAdministratorDTO> findById(@PathVariable("id") Long id) {
        DetailedAdministratorDTO detailedAdministratorDTO = administratorService.findById(id);
        return ResponseEntity.ok(detailedAdministratorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedAdministratorDTO> update(@RequestBody @Valid AdministratorUpdateDTO administratorUpdateDTO, @PathVariable("id") Long id) {
        DetailedAdministratorDTO detailedAdministratorDTO = administratorService.update(id, administratorUpdateDTO);
        return ResponseEntity.ok(detailedAdministratorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        administratorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas")
    public CollectionModel<EntityModel<AdministratorListDTO>> findAllAdministratorsHateoas(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        List<EntityModel<AdministratorListDTO>> administrators = administratorService.find(pagination).stream()
                .map(administrator -> EntityModel.of(administrator,
                        linkTo(methodOn(AdministratorController.class).findById(administrator.id())).withSelfRel()))
                .toList();

        return CollectionModel.of(administrators, linkTo(methodOn(AdministratorController.class).find(null)).withSelfRel());
    }
}
