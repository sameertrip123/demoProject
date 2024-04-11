package com.example.demoProject.controller;

import com.example.demoProject.dto.CandidateRequest;
import com.example.demoProject.dto.CandidateResponse;
import com.example.demoProject.entity.Candidate;
import com.example.demoProject.exception.CandidateNotFoundException;
import com.example.demoProject.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<Object> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidate();
        return CandidateResponse.generateResponse("Successfully fetched data", "is-success", HttpStatus.OK, candidates,null);
    }

    @PostMapping("/candidates")
    public ResponseEntity<Candidate> saveCandidate(@RequestBody @Valid CandidateRequest request) {
        return new ResponseEntity<>(candidateService.saveCandidate(request), HttpStatus.CREATED);
    }

    @GetMapping("/candidates/{candidateId}")
    public ResponseEntity<Object> getCandidateById(@PathVariable int candidateId) throws CandidateNotFoundException {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        return CandidateResponse.generateResponse("Successfully retrieved data", "is-success", HttpStatus.OK, candidate, null);
    }
}
