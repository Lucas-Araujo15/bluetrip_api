package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.service.DetailedServiceDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceListDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceRegisterDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceUpdateDTO;
import com.api.bluetrip.services.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ServiceListDTO>> create(@RequestBody @Valid ServiceRegisterDTO serviceRegisterDTO) {
        ServiceListDTO serviceListDTO = serviceService.create(serviceRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(ServiceController.class).findById(serviceListDTO.id())).toUri())
                .body(EntityModel.of(serviceListDTO,
                        linkTo(methodOn(ServiceController.class).findById(serviceListDTO.id())).withSelfRel(),
                        linkTo(methodOn(ServiceController.class).find(null)).withRel("services")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedServiceDTO> findById(@PathVariable("id") Long id) {
        DetailedServiceDTO detailedServiceDTO = serviceService.findById(id);
        return ResponseEntity.ok(detailedServiceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedServiceDTO> update(@RequestBody @Valid ServiceUpdateDTO serviceUpdateDTO, @PathVariable("id") Long id) {
        DetailedServiceDTO detailedServiceDTO = serviceService.update(id, serviceUpdateDTO);
        return ResponseEntity.ok(detailedServiceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        serviceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
