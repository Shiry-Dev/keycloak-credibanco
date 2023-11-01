package com.openfinanceorganisation.businessrule.validator;

import com.openfinanceorganisation.businessrule.exception.EntityAlreadyExistsException;
import com.openfinanceorganisation.businessrule.exception.NotFoundException;
import com.openfinanceorganisation.businessrule.messages.MessageSourceService;
import com.openfinanceorganisation.domain.Organisation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrganisationValidator {

    private static final String ORG_RESOURCE_ALREADY_EXISTS = "elementary-branch.entity-already-exists";

    private final MessageSourceService messageSourceService;

    public void validateOrgDoesNotExist(Optional<Organisation> organisation) {
        if (organisation.isPresent()) {
            throw new EntityAlreadyExistsException(messageSourceService.getMessage(ORG_RESOURCE_ALREADY_EXISTS));
        }
    }

}
