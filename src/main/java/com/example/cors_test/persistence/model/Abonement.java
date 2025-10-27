package com.example.cors_test.persistence.model;

import com.example.cors_test.enumerated.AbonementDuration;
import com.example.cors_test.enumerated.AbonementType;
import com.example.cors_test.enumerated.ActivityType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "abonements")
public class Abonement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // продолжительность абонемента
    @Enumerated(EnumType.STRING)
    private AbonementDuration duration;

    // enum в котором зал \ бассейн \ йога
    @Enumerated(EnumType.STRING)
    private ActivityType activity;

    // заказы
    @OneToMany(mappedBy = "abonement", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    // время создания
    private LocalDateTime createdAt;

    // время удаления
    private LocalDateTime closedAt;

    // время изменения
    private LocalDateTime changeAt;

    public Abonement() {}
}
