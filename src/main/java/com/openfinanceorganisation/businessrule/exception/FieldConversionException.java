package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorCode;
import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

@Getter
@ToString
public class FieldConversionException extends RuntimeException {
    private final Set<ErrorData> errors;



    public FieldConversionException(final Set<ErrorData> errors) {
        this(null, null, errors);
    }

    public FieldConversionException(final String message, final Throwable cause, final Set<ErrorData> errors) {
        super(message, cause);
        Assert.notNull(errors, "Errors List must not be null");
        errors.forEach(error -> {
            error.setTitle(ErrorCode.INTERNAL_ERROR.name().concat(StringUtils.SPACE).concat(error.getTitle()));
            error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        });
        this.errors = errors;
    }

}
