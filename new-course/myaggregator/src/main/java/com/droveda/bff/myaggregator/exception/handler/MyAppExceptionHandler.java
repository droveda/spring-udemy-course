package com.droveda.bff.myaggregator.exception.handler;

import com.droveda.bff.myaggregator.exception.BusinessException;
import com.droveda.bff.myaggregator.exception.InfraServiceException;
import com.droveda.bff.myaggregator.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

@ControllerAdvice
public class MyAppExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(MyAppExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleException(BusinessException ex) {
        return build(HttpStatus.BAD_REQUEST, ex, problem -> {
            problem.setTitle(ex.getMessage());
        });
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleException(UserNotFoundException ex) {
        return build(HttpStatus.NOT_FOUND, ex, problem -> {
            problem.setTitle(ex.getMessage());
        });
    }

    @ExceptionHandler(InfraServiceException.class)
    public ProblemDetail handleException(InfraServiceException ex) {
        log.error(ex.getMessage(), ex);

        if (Objects.isNull(ex.getHttpStatus())) {
            return build(HttpStatus.SERVICE_UNAVAILABLE, ex, problem -> {
                problem.setTitle(ex.getMessage());
            });
        }

        return build(ex.getHttpStatus(), ex, problem -> {
            problem.setTitle(ex.getMessage());
        });
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, problem -> {
            problem.setTitle(ex.getMessage());
        });
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid request");
        problemDetail.setTitle(request.getDescription(false));

        List<String> messages = ex.getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .toList();
        Map<String, Object> map = new HashMap<>();
        map.put("errors", messages);

        problemDetail.setProperties(map);

        return new ResponseEntity<>(
                problemDetail, HttpStatus.BAD_REQUEST
        );
    }

    private ProblemDetail build(HttpStatus status, Exception ex, Consumer<ProblemDetail> consumer) {
        var problem = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        consumer.accept(problem);

        return problem;
    }

}
