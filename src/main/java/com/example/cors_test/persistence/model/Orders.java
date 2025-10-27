package com.example.cors_test.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "abonement_id")
    private Abonement abonement;

    // сумма заказа
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    private LocalDateTime createdAt;

    public Orders() {}
}
