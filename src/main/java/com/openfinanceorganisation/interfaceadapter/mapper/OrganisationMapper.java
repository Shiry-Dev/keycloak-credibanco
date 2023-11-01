package com.openfinanceorganisation.interfaceadapter.mapper;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;
import com.openfinanceorganisation.domain.Organisation;

public interface OrganisationMapper {

    public OrganisationDTO fromEntityToDto (Organisation organisation);
}
