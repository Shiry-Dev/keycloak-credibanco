package com.openfinanceorganisation.businessrule.exception.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Builder
@AllArgsConstructor
public class ErrorData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String code;
    private String title;
    private String detail;
    private final OffsetDateTime requestDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.SECONDS);

}
