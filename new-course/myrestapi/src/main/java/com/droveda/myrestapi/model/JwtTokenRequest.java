package com.droveda.myrestapi.model;

public record JwtTokenRequest(
        String username,
        String password
) {
}
