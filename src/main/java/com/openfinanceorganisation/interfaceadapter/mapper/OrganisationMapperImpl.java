package com.openfinanceorganisation.interfaceadapter.mapper;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.domain.Organisation;
import org.springframework.stereotype.Component;

@Component
public class OrganisationMapperImpl implements OrganisationMapper{

    @Override
    public OrganisationDTO fromEntityToDto (Organisation organisation){
        if ( organisation == null){
            return null;
        }

        OrganisationDTO.OrganisationDTOBuilder organisationDto = OrganisationDTO.builder();

        organisationDto.organisationId( organisation.getOrganisationId() );
        organisationDto.createdOn( organisation.getCreatedOn() );
        organisationDto.addressLineOne( organisation.getAddressLineOne() );
        organisationDto.addressLineTwo( organisation.getAddressLineTwo() );
        organisationDto.city(organisation.getCity() );
        organisationDto.companyRegister( organisation.getCompanyRegister() );
        organisationDto.country( organisation.getCountry() );
        organisationDto.countryOfRegistration( organisation.getCountryOfRegistration() );
        organisationDto.legalEntityName( organisation.getLegalEntityName() );
        organisationDto.organisationName( organisation.getOrganisationName() );
        organisationDto.parentOrganisationReference( organisation.getParentOrganisationReference() );
        organisationDto.postCode( organisation.getPostCode() );
        organisationDto.registeredName( organisation.getRegisteredName() );
        organisationDto.registrationId( organisation.getRegistrationId() );
        organisationDto.registrationNumber( organisation.getRegistrationNumber() );
        organisationDto.requiresParticipantsTermsAndConditionsSigning( organisation.getRequiresParticipantsTermsAndConditionsSigning() );
        organisationDto.size( organisation.getSize() );


        return organisationDto.build();
    }
}
