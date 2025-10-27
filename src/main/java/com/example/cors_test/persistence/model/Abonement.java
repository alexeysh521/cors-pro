package com.example.cors_test.persistence.model;

import com.example.cors_test.enumerated.AbonementDuration;
import com.example.cors_test.enumerated.AbonementType;
import com.example.cors_test.enumerated.ActivityType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "abonements")
public class Abonement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // тип абонемента
    @Enumerated(EnumType.STRING)
    private AbonementType type;

    // продолжительность абонемента
    @Enumerated(EnumType.STRING)
    private AbonementDuration duration;

    // enum в котором зал \ бассейн \ йога
    @Enumerated(EnumType.STRING)
    private ActivityType activity;

    // заказы
    @OneToOne(mappedBy = "abonement")
    private Orders order;

    // время создания
    private LocalDateTime createdAt;

    public Abonement() {}
}
