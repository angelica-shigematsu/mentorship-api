package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.mentordev.voluntario.domain.model.Role;

@Builder
public record ListUserDTO(

        @NotBlank
        long id,

        @NotBlank
        String fullname,

        @NotBlank
        String email,

        @NotBlank
        Role role,

        @NotBlank
        boolean active) {
}
