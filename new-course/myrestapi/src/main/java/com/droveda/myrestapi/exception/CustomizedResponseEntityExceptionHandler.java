package com.droveda.myrestapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false))
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(UserNotFound ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(
                new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false))
                , HttpStatus.NOT_FOUND
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        String result = "";
        String defaultMessage = ex.getFieldErrors()
                .stream().reduce(result, (partialString, fieldError) -> partialString + fieldError.getDefaultMessage() + ", ", String::concat);

        return new ResponseEntity<>(
                new ErrorDetails(LocalDateTime.now(), defaultMessage, request.getDescription(false))
                , HttpStatus.BAD_REQUEST
        );
    }
}
