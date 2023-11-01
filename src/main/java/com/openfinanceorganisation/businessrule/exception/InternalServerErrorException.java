package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class InternalServerErrorException extends BaseException {

    static final long serialVersionUID = -1033896140745516769L;

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(final String message, final Set<ErrorData> errors) {
        super(message, errors);
    }

    public InternalServerErrorException(final Set<ErrorData> errors) {
        super(errors);
    }

    public InternalServerErrorException(final ErrorData... errors) {
        super(errors);
    }

    public InternalServerErrorException(final String message) {
        super(message);
    }

    public InternalServerErrorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InternalServerErrorException(final Throwable cause) {
        super(cause);
    }

}
