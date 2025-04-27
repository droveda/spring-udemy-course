package com.droveda.bff.myaggregator.exception.handler;

import com.droveda.bff.myaggregator.exception.BusinessException;
import com.droveda.bff.myaggregator.exception.UserNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@ControllerAdvice
public class MyAppExceptionHandler extends ResponseEntityExceptionHandler {

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
