package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mentordev.voluntario.domain.model.User;

public record CreateProfileDTO(
        @NotBlank
        String bio,

        @NotBlank
        String expert,

        @NotNull
        User user) {
}
