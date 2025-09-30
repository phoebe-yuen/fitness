package com.example.fitness.repo;

import com.example.fitness.domain.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface fitnessClassRepository extends JpaRepository<FitnessClass, UUID> {
}
