package com.example.demoProject.repository;

import com.example.demoProject.entity.CandidateWorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateWorkHistoryRepository extends JpaRepository<CandidateWorkHistory, Integer> {
}
