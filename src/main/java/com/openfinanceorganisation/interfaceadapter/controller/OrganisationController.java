package com.openfinanceorganisation.interfaceadapter.controller;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.businessrule.usecase.InsertOrganisationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OrganisationController {

    private final InsertOrganisationUseCase organisationUseCase;

    public OrganisationController(InsertOrganisationUseCase organisationUseCase) {
        this.organisationUseCase = organisationUseCase;
    }

    @PostMapping("/api/organisation")
    public ResponseEntity<OrganisationDTO> insertOrganisation(@RequestBody OrganisationDTO newBodyOrg){

        OrganisationDTO newOrg = organisationUseCase.insertOrganisation(newBodyOrg);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newOrg.getOrganisationId())
                .toUri();

        return ResponseEntity.created(uri).body(newOrg);
    }
}
