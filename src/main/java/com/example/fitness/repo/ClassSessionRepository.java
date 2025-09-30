package com.example.fitness.repo;

import com.example.fitness.domain.ClassSession;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClassSessionRepository extends JpaRepository<ClassSession, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from ClassSession s where s.id = :id")
    Optional<ClassSession> findByIdForUpdate(@Param("id") UUID id);

    @Query("select s from ClassSession s where s.startTime between :from and :to")
    List<ClassSession> findInRange(@Param("from") Instant from, @Param("to") Instant to);

}