package com.example.demoProject.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CandidateRequest {
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;

    @Email(message = "Invalid Email Address")
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number")
    private String contact;
}
