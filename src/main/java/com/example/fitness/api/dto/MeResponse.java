package com.example.fitness.api.dto;

import com.example.fitness.domain.Role;

import java.util.UUID;

public record MeResponse(UUID id, String email, Role role) {
}
