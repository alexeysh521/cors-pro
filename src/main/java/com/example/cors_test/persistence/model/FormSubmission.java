package com.example.cors_test.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "form_submissions")
@Data
public class FormSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String textArea;
    private String trainId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public FormSubmission() {}

    public FormSubmission(String trainId, String name, String email, String textArea) {
        this.trainId = trainId;
        this.name = name;
        this.email = email;
        this.textArea = textArea;
    }
}
