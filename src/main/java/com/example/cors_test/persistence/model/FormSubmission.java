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
    private String message;

    @Column(columnDefinition = "TEXT")
    private String formData;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "page_url")
    private String pageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
