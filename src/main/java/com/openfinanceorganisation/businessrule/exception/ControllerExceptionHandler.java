package com.openfinanceorganisation.businessrule.exception;

import com.openfinanceorganisation.businessrule.exception.entities.ErrorCode;
import com.openfinanceorganisation.businessrule.exception.entities.ErrorData;
import com.openfinanceorganisation.businessrule.exception.entities.MetaDataEnvelope;
import com.openfinanceorganisation.businessrule.messages.MessageSourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;
import java.util.Set;

import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String BAD_REQUEST_CODE = HttpStatus.BAD_REQUEST.toString();
    private static final String NOT_FOUND_CODE = HttpStatus.NOT_FOUND.toString();
    private static final String ALREADY_EXISTS_CODE =HttpStatus.CONFLICT.toString();
    private static final String PARTIAL_CONTENT_CODE = HttpStatus.PARTIAL_CONTENT.toString();
    private static final String UNAUTHORIZED_CODE = HttpStatus.UNAUTHORIZED.toString();
    private static final String FORBIDDEN_CODE = HttpStatus.FORBIDDEN.toString();
    private static final String UNPROCESSABLE_ENTITY_CODE = HttpStatus.UNPROCESSABLE_ENTITY.toString();
    private static final String SERVICE_UNAVAILABLE_CODE = HttpStatus.SERVICE_UNAVAILABLE.toString();
    private static final String INTERNAL_SERVER_ERROR_CODE = HttpStatus.INTERNAL_SERVER_ERROR.toString();
    private static final String EXCEPTION = "exception";
    private static final String NO_CONTENT_CODE = HttpStatus.NO_CONTENT.toString();
    private static final String PROPERTIES_DEFAULT_ERROR_MSG = "elementary-branch.default-error-msg";
    private static final String HEADER_NOT_FOUND = "elementary-branch.missing-header-msg";

    private final MessageSourceService messageSourceService;


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(final Exception exception,
                                                            final WebRequest request) {
        final ValidationException validationException = (ValidationException) exception;
        final var response = new MetaDataEnvelope<>(validationException.getErrors());
        log.debug("ValidationException: {}", response);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(FieldConversionException.class)
    public ResponseEntity<Object> handleFieldConversionException(final Exception exception,
                                                                 final WebRequest request) {
        final FieldConversionException fieldConversionException = (FieldConversionException) exception;
        final var response = new MetaDataEnvelope<>(fieldConversionException.getErrors());
        log.debug("FieldConversionException: {}", response);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(final RuntimeException exception,
                                                                final WebRequest request) {
        final EntityNotFoundException entityNotFoundException = (EntityNotFoundException) exception;
        final var response =
                new MetaDataEnvelope<>(NOT_FOUND_CODE, ErrorCode.NOT_FOUND, entityNotFoundException.getMessage());
        log.error("EntityNotFoundException: {}", response);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(final RuntimeException exception,
                                                          final WebRequest request) {
        final BusinessException businessException = (BusinessException) exception;
        var envelope =
                new MetaDataEnvelope<>(UNPROCESSABLE_ENTITY_CODE, ErrorCode.BUSINESS_ERROR, businessException.getMessage());

        if (!isEmpty(businessException.getErrors())) {
            envelope = new MetaDataEnvelope<>(businessException.getErrors());
        }
        final String errorMessage = MessageFormat.format("BusinessException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException exception,
                                                          final WebRequest request) {
        final NotFoundException notFoundException = (NotFoundException) exception;

        var envelope =
                new MetaDataEnvelope<>(NOT_FOUND_CODE, ErrorCode.NOT_FOUND, notFoundException.getMessage());

        if (!isEmpty(notFoundException.getErrors())) {
            envelope = new MetaDataEnvelope<>(notFoundException.getErrors());
        }

        final String errorMessage = MessageFormat.format("NotFoundException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExists(final RuntimeException exception,
                                                          final WebRequest request) {
        final EntityAlreadyExistsException alreadyExistsException = (EntityAlreadyExistsException) exception;

        var envelope =
                new MetaDataEnvelope<>(ALREADY_EXISTS_CODE, ErrorCode.ALREADY_EXISTS, alreadyExistsException.getMessage());

        if (!isEmpty(alreadyExistsException.getErrors())) {
            envelope = new MetaDataEnvelope<>(alreadyExistsException.getErrors());
        }

        final String errorMessage = MessageFormat.format("AlreadyExists: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(PartialContentException.class)
    public ResponseEntity<Object> handlePartialContentException(final RuntimeException exception,
                                                                final WebRequest request) {
        final PartialContentException partialContentException = (PartialContentException) exception;

        var envelope =
                new MetaDataEnvelope<>(PARTIAL_CONTENT_CODE, ErrorCode.PARTIAL_CONTENT, partialContentException.getMessage());

        if (!isEmpty(partialContentException.getErrors())) {
            envelope = new MetaDataEnvelope<>(partialContentException.getErrors());
        }

        final String errorMessage = MessageFormat.format("PartialContentException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(final RuntimeException exception,
                                                              final WebRequest request) {
        final UnauthorizedException unauthorizedException = (UnauthorizedException) exception;

        var envelope =
                new MetaDataEnvelope<>(UNAUTHORIZED_CODE, ErrorCode.UNAUTHORIZED, unauthorizedException.getMessage());

        if (!isEmpty(unauthorizedException.getErrors())) {
            envelope = new MetaDataEnvelope<>(unauthorizedException.getErrors());
        }

        final String errorMessage = MessageFormat.format("UnauthorizedException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    public ResponseEntity<Object> handleEmptyConsentIdException(final MissingRequestHeaderException missingRequestHeaderException,
                                                                final WebRequest request) {

        final var errors = Set.of(ErrorData.builder()
                .title(ErrorCode.BAD_REQUEST.name())
                .code(BAD_REQUEST_CODE)
                .detail(messageSourceService.getMessage(HEADER_NOT_FOUND, missingRequestHeaderException.getHeaderName()))
                .build());

        var envelope =
                new MetaDataEnvelope<>(errors);

        final var errorMessage = MessageFormat.format("EmptyConsentException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, missingRequestHeaderException);

        return handleExceptionInternal(missingRequestHeaderException, envelope, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(final RuntimeException exception,
                                                           final WebRequest request) {
        final ForbiddenException forbiddenException = (ForbiddenException) exception;

        var envelope =
                new MetaDataEnvelope<>(FORBIDDEN_CODE, ErrorCode.FORBIDDEN, forbiddenException.getMessage());

        if (!isEmpty(forbiddenException.getErrors())) {
            envelope = new MetaDataEnvelope<>(forbiddenException.getErrors());
        }

        final String errorMessage = MessageFormat.format("ForbiddenException: {0}", envelope);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, envelope, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Object> handleInternalServerErrorException(final RuntimeException exception,
                                                                     final WebRequest request) {
        final InternalServerErrorException internalServerErrorException = (InternalServerErrorException) exception;
        var response =
                new MetaDataEnvelope<>(INTERNAL_SERVER_ERROR_CODE, ErrorCode.INTERNAL_ERROR, internalServerErrorException.getMessage());

        if (!isEmpty(internalServerErrorException.getErrors())) {
            response = new MetaDataEnvelope<>(internalServerErrorException.getErrors());
        }

        final String errorMessage = MessageFormat.format("InternalServerErrorException: {0}", response);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<Object> handleGatewayException(final RuntimeException exception,
                                                         final WebRequest request) {
        final GatewayException gatewayException = (GatewayException) exception;
        var response =
                new MetaDataEnvelope<>(SERVICE_UNAVAILABLE_CODE, ErrorCode.GATEWAY_ERROR, gatewayException.getMessage());

        if (!isEmpty(gatewayException.getErrors())) {
            response = new MetaDataEnvelope<>(gatewayException.getErrors());
        }

        final String errorMessage = MessageFormat.format("GatewayException: {0}", response);
        log.error(errorMessage, EXCEPTION, exception);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, request);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Object> handleNoContentException(final NoContentException exception,
                                                           final WebRequest request) {
        final String warnMessage = MessageFormat.format("NoContentException: {0}", exception.getMessage());
        log.debug(warnMessage, NO_CONTENT_CODE, exception.getLocalizedMessage());

        return handleExceptionInternal(exception, null, new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

}
