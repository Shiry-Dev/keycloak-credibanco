package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;

import java.util.Set;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(final Set<ErrorData> errors) {
        super(errors);
    }

    public UnauthorizedException(final String message) {
        super(message);
    }

    public UnauthorizedException() {

    }
}
