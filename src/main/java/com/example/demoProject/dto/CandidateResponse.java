package com.example.demoProject.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CandidateResponse {
    public static ResponseEntity<Object> generateResponse(String message, String messageType, HttpStatus status, Object data, Object errors) {
        Map<String, Object> mp = new HashMap<>();

        mp.put("message", message);
        mp.put("message-type", messageType);
        mp.put("status", status);
        mp.put("data", data);
        mp.put("error", errors);

        return new ResponseEntity<>(mp, status);
    }
}
