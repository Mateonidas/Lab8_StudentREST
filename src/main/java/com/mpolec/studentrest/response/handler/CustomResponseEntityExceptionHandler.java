package com.mpolec.studentrest.response.handler;

import com.mpolec.studentrest.response.ResponseDetailsStatusException;
import com.mpolec.studentrest.response.model.ErrorResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseDetailsStatusException.class)
    public final ResponseEntity<Object> handleResponseDetailsStatusException(ResponseDetailsStatusException ex, WebRequest request) {

        ErrorResponseModel errors = new ErrorResponseModel(
                LocalDateTime.now(),
                ex.getStatus(),
                ex.getStatus().value(),
                ex.getReason(),
                ex.getDetails());

        return new ResponseEntity<>(errors, ex.getStatus());
    }

}
