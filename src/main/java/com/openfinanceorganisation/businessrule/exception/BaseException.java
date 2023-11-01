package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class BaseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -9034816190742716963L;

    private Set<ErrorData> errors;

    public BaseException() {
        super();
    }

    public BaseException(final Set<ErrorData> errors) {
        this.errors = errors;
    }

    public BaseException(final ErrorData... errors) {
        this.errors = Arrays.stream(errors).collect(Collectors.toSet());
    }

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, final Set<ErrorData> errors) {
        super(message);
        this.errors = errors;
    }

    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BaseException(final String message, final Throwable cause, final Set<ErrorData> errors) {
        super(message, cause);
        this.errors = errors;
    }

    public BaseException(final Throwable cause) {
        super(cause);
    }

    public BaseException(final Throwable cause, final Set<ErrorData> errors) {
        super(cause);
        this.errors = errors;
    }
}
