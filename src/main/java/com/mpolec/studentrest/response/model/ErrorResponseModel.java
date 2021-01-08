package com.mpolec.studentrest.response.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
public class ErrorResponseModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private int code;
    private String message;
    private List<String> details;


    public ErrorResponseModel(LocalDateTime timestamp, HttpStatus status, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }


    public ErrorResponseModel(LocalDateTime timestamp, HttpStatus status, String message, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        details = Collections.singletonList(error);
    }

    public ErrorResponseModel(LocalDateTime timestamp, HttpStatus status, int code, String message, List<String> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public ErrorResponseModel(LocalDateTime timestamp, HttpStatus status, int code, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.code = code;
        this.message = message;

    }

}
