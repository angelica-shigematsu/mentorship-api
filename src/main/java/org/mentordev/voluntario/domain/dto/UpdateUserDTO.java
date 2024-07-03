package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.NotBlank;
import org.mentordev.voluntario.domain.model.Role;

public record UpdateUserDTO(
        @NotBlank
        String fullname,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        Role role,

        @NotBlank
        boolean active) {
}
