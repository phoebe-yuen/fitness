package com.example.fitness.api.dto;

import com.example.fitness.domain.SessionStatus;

import java.time.Instant;
import java.util.UUID;

public record SessionResponse(UUID id, UUID classId, String className, Instant startTime, Instant endTime, int capacity,
                              int remaining, SessionStatus status, String location) {
}
