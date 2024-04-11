package com.example.demoProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "candidate_education_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEducationHistory {
    private int id;

    private String instituteName;

    private String educationQualification;

    private String educationSpecialization;

    private String educationLocation;

    private Date educationStartDate;

    private Date educationEndDate;

    private String educationDescription;

    private boolean isManuallyAdded;
}
