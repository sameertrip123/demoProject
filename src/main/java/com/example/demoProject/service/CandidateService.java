package com.example.demoProject.service;

import com.example.demoProject.dto.CandidateRequest;
import com.example.demoProject.entity.Candidate;
import com.example.demoProject.exception.CandidateNotFoundException;
import com.example.demoProject.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate saveCandidate(CandidateRequest request) {
        Candidate candidate = Candidate.build(0, request.getFirstName(), request.getLastName(), request.getEmail(), request.getContact());
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(int id) throws CandidateNotFoundException {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isEmpty()) {
            throw new CandidateNotFoundException("User not found with id " + id);
        }
        return candidate.get();
    }
}
