package com.example.fitness.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="registrations", uniqueConstraints = @UniqueConstraint(columnNames={"user_id","session_id"}))
@Getter
@Setter
public class Registration {
    @Id @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false) @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false) @JoinColumn(name = "session_id")
    private ClassSession session;

    @Column(nullable = false, updatable = false)
    private Instant createAt = Instant.now();

}