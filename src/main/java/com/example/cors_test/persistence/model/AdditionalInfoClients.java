package com.example.cors_test.persistence.model;

import com.example.cors_test.enumerated.Genders;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "additional_info_client")
public class AdditionalInfoClients {

    @Id
    private Integer id;

    private String firstName;
    private String overageName;
    private String lastName;

    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Genders gender;

    private LocalDateTime dateOfBirth;

    @OneToOne(mappedBy = "additionalInfo")
    private Clients client;

    public AdditionalInfoClients(){}

}
