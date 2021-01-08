package com.mpolec.studentrest.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ResponseDetailsStatusException extends ResponseStatusException {

    private List<String> details;

    private String message;

    public ResponseDetailsStatusException(HttpStatus status) {
        super(status);
    }

    public ResponseDetailsStatusException(HttpStatus status, String message) {
        super(status, message);
        this.message = message;
    }

    public ResponseDetailsStatusException(HttpStatus status, String message, List<String> details) {
        super(status,message);
        this.message = message;
        this.details = details;
    }

    public ResponseDetailsStatusException(HttpStatus status, String message, Throwable cause) {
        super(status, message, cause);
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
