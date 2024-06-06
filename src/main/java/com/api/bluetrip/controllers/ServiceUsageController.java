package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.serviceusage.DetailedServiceUsageDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.ServiceUsageListDTO;
import com.api.bluetrip.controllers.dtos.serviceusage.ServiceUsageRegisterDTO;
import com.api.bluetrip.services.ServiceUsageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/service-usage")
public class ServiceUsageController {
    private final ServiceUsageService serviceUsageService;

    @Autowired
    public ServiceUsageController(ServiceUsageService serviceUsageService) {
        this.serviceUsageService = serviceUsageService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ServiceUsageListDTO>> create(@RequestBody @Valid ServiceUsageRegisterDTO serviceUsageRegisterDTO) {
        ServiceUsageListDTO serviceUsageListDTO = serviceUsageService.create(serviceUsageRegisterDTO);

        return ResponseEntity
                .created(linkTo(methodOn(ServiceUsageController.class).findById(serviceUsageListDTO.id())).toUri())
                .body(EntityModel.of(serviceUsageListDTO,
                        linkTo(methodOn(ServiceUsageController.class).findById(serviceUsageListDTO.id())).withSelfRel(),
                        linkTo(methodOn(ServiceUsageController.class).find(null)).withRel("service-usages")));
    }

    @GetMapping
    public ResponseEntity<Page<ServiceUsageListDTO>> find(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<ServiceUsageListDTO> page = serviceUsageService.find(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedServiceUsageDTO> findById(@PathVariable("id") Long id) {
        DetailedServiceUsageDTO detailedServiceUsageDTO = serviceUsageService.findById(id);
        return ResponseEntity.ok(detailedServiceUsageDTO);
    }
 }
