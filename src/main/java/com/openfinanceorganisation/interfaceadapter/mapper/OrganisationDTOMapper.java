package com.openfinanceorganisation.interfaceadapter.mapper;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.domain.Organisation;

public interface OrganisationDTOMapper {

    public Organisation fromDtoToEntity (OrganisationDTO organisationDTO);
}
