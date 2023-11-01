package com.openfinanceorganisation.businessrule.exception.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaDataEnvelope<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Set<ErrorData> errors = new HashSet<>();
    @JsonUnwrapped
    private T successData;

    public MetaDataEnvelope(final String statusCode,
                            final ErrorCode errorCode,
                            final String message) {
        this.addErrorData(statusCode, errorCode, message);
    }

    public MetaDataEnvelope(final Set<ErrorData> errors) {
        this.errors.addAll(errors);
    }

    private void addErrorData(final String statusCode,
                              final ErrorCode errorCode,
                              final String detail) {
        this.errors.add(ErrorData.builder()
                .title(errorCode.name())
                .code(statusCode)
                .detail(detail)
                .build());
    }
}