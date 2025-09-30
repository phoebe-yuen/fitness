package com.example.fitness.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="class_session")
@Getter
@Setter
public class ClassSession {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne(optional=false)
    private FitnessClass fitnessClass;

    @Column(nullable=false)
    private Instant startTime;

    @Column(nullable=false)
    private Instant endTime;

    @Column(nullable=false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionStatus status = SessionStatus.OPEN;

    private String location;
}
