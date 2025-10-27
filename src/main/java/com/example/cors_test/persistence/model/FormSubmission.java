package com.example.cors_test.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "form_submissions")
@Data
public class FormSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // например, "contact_form", "abonement_request", "feedback"
    private String formType;

    // ID блока на сайте
    private String trainId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();


    @ElementCollection
    @CollectionTable(
            name = "form_submission_params",
            joinColumns = @JoinColumn(name = "form_submission_id")
    )
    @MapKeyColumn(name = "param_key")
    @Column(name = "param_value")
    private Map<String, String> allParams = new HashMap<>();


    public FormSubmission() {}

}
