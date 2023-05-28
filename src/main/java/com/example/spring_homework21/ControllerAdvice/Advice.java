package com.example.spring_homework21.ControllerAdvice;

import com.example.spring_homework21.ApiException.ApiException;
import com.example.spring_homework21.ApiResponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> ApiException (ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse> NullPointerException (NullPointerException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }
}
