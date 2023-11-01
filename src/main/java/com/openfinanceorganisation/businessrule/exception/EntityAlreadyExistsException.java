package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;

import java.util.Set;

public class EntityAlreadyExistsException extends BaseException {

    public EntityAlreadyExistsException(final Set<ErrorData> errors) {
        super(errors);
    }

    public EntityAlreadyExistsException(final String message) {
        super(message);
    }

    public EntityAlreadyExistsException() {

    }
}