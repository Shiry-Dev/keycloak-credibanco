package com.openfinanceorganisation.interfaceadapter.mapper;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.domain.Organisation;
import org.springframework.stereotype.Component;

@Component
public class OrganisationDTOMapperImpl implements OrganisationDTOMapper {

    @Override
    public Organisation fromDtoToEntity (OrganisationDTO organisationDTO){
        if ( organisationDTO == null){
            return null;
        }

        Organisation.OrganisationBuilder organisation = Organisation.builder();

        organisation.addressLineOne( organisationDTO.getAddressLineOne() );
        organisation.addressLineTwo( organisationDTO.getAddressLineTwo() );
        organisation.city(organisationDTO.getCity() );
        organisation.companyRegister( organisationDTO.getCompanyRegister() );
        organisation.country( organisationDTO.getCountry() );
        organisation.countryOfRegistration( organisationDTO.getCountryOfRegistration() );
        organisation.legalEntityName( organisationDTO.getLegalEntityName() );
        organisation.organisationName( organisationDTO.getOrganisationName() );
        organisation.parentOrganisationReference( organisationDTO.getParentOrganisationReference() );
        organisation.postCode( organisationDTO.getPostCode() );
        organisation.registeredName( organisationDTO.getRegisteredName() );
        organisation.registrationId( organisationDTO.getRegistrationId() );
        organisation.registrationNumber( organisationDTO.getRegistrationNumber() );
        organisation.requiresParticipantsTermsAndConditionsSigning( organisationDTO.getRequiresParticipantsTermsAndConditionsSigning() );
        organisation.size( organisationDTO.getSize() );


        return organisation.build();
    }
}
