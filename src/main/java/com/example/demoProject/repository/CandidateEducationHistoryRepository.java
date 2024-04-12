package com.example.demoProject.repository;

import com.example.demoProject.entity.CandidateEducationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateEducationHistoryRepository extends JpaRepository<CandidateEducationHistory, Integer> {
}
