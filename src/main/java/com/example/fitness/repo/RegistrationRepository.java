package com.example.fitness.repo;

import com.example.fitness.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
    long countBySession_Id(UUID sessionId);

    boolean existsByUser_IdAndSession_Id(UUID userId, UUID sessionId);

    void deleteByUser_IdAndSession_Id(UUID userId, UUID sessionId);
}
