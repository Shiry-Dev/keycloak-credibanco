package com.openfinanceorganisation.businessrule.usecase;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.businessrule.validator.OrganisationValidator;
import com.openfinanceorganisation.domain.Organisation;
import com.openfinanceorganisation.interfaceadapter.mapper.OrganisationDTOMapper;
import com.openfinanceorganisation.interfaceadapter.mapper.OrganisationMapper;
import com.openfinanceorganisation.interfaceadapter.repository.OrganisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class InsertOrganisationUseCaseImpl implements InsertOrganisationUseCase {

    private final OrganisationRepository organisationRepository;
    private  final OrganisationDTOMapper organisationDTOMapper;
    private final OrganisationMapper organisationMapper;
    private final OrganisationValidator organisationValidator;
    public InsertOrganisationUseCaseImpl(OrganisationRepository organisationRepository, OrganisationDTOMapper organisationDTOMapper, OrganisationMapper organisationMapper, OrganisationValidator organisationValidator) {
        this.organisationRepository = organisationRepository;
        this.organisationDTOMapper = organisationDTOMapper;
        this.organisationMapper = organisationMapper;
        this.organisationValidator = organisationValidator;
    }

    @Transactional
    @Override
    public OrganisationDTO insertOrganisation (OrganisationDTO organisationPayload){

        Optional<Organisation> filteredOrg = organisationRepository.findByLegalEntityName(organisationPayload.getLegalEntityName());

        organisationValidator.validateOrgDoesNotExist(filteredOrg);

        Organisation newOrg = organisationDTOMapper.fromDtoToEntity(organisationPayload);

        newOrg.setCreatedOn(LocalDate.now());

        organisationRepository.save(newOrg);

        return organisationMapper.fromEntityToDto(newOrg);
    }
}
