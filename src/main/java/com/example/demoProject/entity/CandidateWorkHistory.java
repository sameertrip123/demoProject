package com.example.demoProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "candidate_work_history")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String workCompanyName;




}
