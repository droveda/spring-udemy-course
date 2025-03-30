package com.droveda.myrestapi.model;

import java.time.LocalDate;

public record Todo(
        int id,
        String username,
        String description,
        LocalDate targetDate,
        boolean done
) {
}
