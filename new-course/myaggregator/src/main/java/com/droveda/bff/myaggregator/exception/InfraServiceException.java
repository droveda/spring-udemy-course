package com.droveda.bff.myaggregator.exception;

import org.springframework.http.HttpStatus;

public class InfraServiceException extends RuntimeException {

    private HttpStatus httpStatus;

    public InfraServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraServiceException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
