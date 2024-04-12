package com.example.demoProject.advice;


import com.example.demoProject.dto.CandidateResponse;
import com.example.demoProject.exception.CandidateNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> mp = new HashMap<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            mp.put(error.getField(), error.getDefaultMessage());
        }
        return CandidateResponse.generateResponse("Error", "is-fail", HttpStatus.BAD_REQUEST, null , mp);
    }

    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<Object> handleCandidateNotFoundException(CandidateNotFoundException exception) {
        Map<String, String> mp = new HashMap<>();

        mp.put("error", exception.getMessage());
        return CandidateResponse.generateResponse("Error", "is-fail", HttpStatus.BAD_REQUEST, null , mp);
    }
}
