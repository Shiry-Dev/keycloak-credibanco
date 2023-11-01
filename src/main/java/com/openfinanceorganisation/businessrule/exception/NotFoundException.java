package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;

import java.util.Set;

public class NotFoundException extends BaseException {

    public NotFoundException(final Set<ErrorData> errors) {
        super(errors);
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException() {

    }
}
