package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mentordev.voluntario.domain.model.Role;

public record CreateUserDTO(
        @NotBlank
        String fullname,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotNull
        Role role) {
}
