package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;

import java.util.Set;

public class PartialContentException extends BaseException {

    public PartialContentException(final Set<ErrorData> errors) {
        super(errors);
    }

    public PartialContentException(final String message) {
        super(message);
    }

    public PartialContentException() {

    }
}