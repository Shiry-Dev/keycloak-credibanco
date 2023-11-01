package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;

import java.util.Set;

public class ForbiddenException extends BaseException {

    public ForbiddenException(final Set<ErrorData> errors) {
        super(errors);
    }

    public ForbiddenException(final String message) {
        super(message);
    }

    public ForbiddenException() {

    }
}