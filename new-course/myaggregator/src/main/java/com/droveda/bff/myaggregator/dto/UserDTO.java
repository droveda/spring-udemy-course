package com.droveda.bff.myaggregator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserDTO(
        @NotNull
        Integer id,
        @NotEmpty
        @Size(min = 3, max = 50)
        String name,
        @Email
        String email,
        LocalDate birthDate
) {
}
