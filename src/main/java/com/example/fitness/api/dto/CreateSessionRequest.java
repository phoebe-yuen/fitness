package com.example.fitness.api.dto;

import java.time.Instant;
import java.util.UUID;

public record CreateSessionRequest(UUID classId, Instant startTime, Instant endTime, int capacity, String location) {
}
