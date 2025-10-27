package com.example.cors_test.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_info_id")
    private AdditionalInfoClients additionalInfo;

    // заказы клиента
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    public Clients() {}
}
