package com.openfinanceorganisation.businessrule.usecase;

import com.openfinanceorganisation.businessrule.dto.OrganisationDTO;

public interface InsertOrganisationUseCase {

    public OrganisationDTO insertOrganisation (OrganisationDTO organisationPayload);
}
