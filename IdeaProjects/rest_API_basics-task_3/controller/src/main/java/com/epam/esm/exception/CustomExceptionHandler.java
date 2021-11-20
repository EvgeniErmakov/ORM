package com.epam.esm.exception;

import com.epam.esm.entity.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestControllerAdvice
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CustomExceptionHandler {

    private final MessageSource messageSource;

    private static final int INTERNAL_SERVER_ERROR_CODE = 100;
    private static final int BIND_EXCEPTION_ERROR_CODE = 102;
    private static final int CONSTRAINT_VIOLATION_ERROR_CODE = 101;
    private static final String INTERNAL_SERVER_CODE = "error.internalServerError";
    private static final String SPACE_DELIMITER = " ";

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleInternalServerError(RuntimeException exception, Locale locale) {
        String errorMessage = messageSource.getMessage(INTERNAL_SERVER_CODE, new Object[]{}, locale);
        return new ResponseEntity<>(createErrorResponse(errorMessage, INTERNAL_SERVER_ERROR_CODE),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomServiceException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(CustomServiceException exception, Locale locale) {
        String message = messageSource.getMessage(exception.getErrorMessage(), new Object[]{}, locale);
        String errorMessage = message + SPACE_DELIMITER + exception.getMessage();
        return new ResponseEntity<>(createErrorResponse(errorMessage, exception.getErrorCode()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleBindExceptionException(BindException exception, Locale locale) {
        CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
                .errorMessage(exception.getBindingResult().getAllErrors()
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        error -> ((FieldError) error).getField(),
                                        error -> messageSource.getMessage(error, locale),
                                        (existing, replacement) -> existing
                                )
                        )
                )
                .errorStatusCode(BIND_EXCEPTION_ERROR_CODE)
                .build();
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
                .errorMessage(exception.getConstraintViolations()
                        .stream()
                        .collect(
                                Collectors.toMap(constraintViolation -> StreamSupport
                                                .stream(constraintViolation.getPropertyPath().spliterator(), false)
                                                .reduce((x, y) -> y).orElse(null),
                                        ConstraintViolation::getMessage,
                                        (existing, replacement) -> existing
                                )
                        ))
                .errorStatusCode(CONSTRAINT_VIOLATION_ERROR_CODE)
                .build();
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse createErrorResponse(String errorMessage, int errorCode) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(errorMessage);
        response.setErrorStatusCode(errorCode);
        return response;
    }
}
