package org.mentordev.voluntario.domain.dto;

import org.mentordev.voluntario.domain.model.*;
import org.mentordev.voluntario.domain.model.User;

import java.util.List;

public record ListProfileDTO(
        long id,

        String bio,

        String expertise,

        User user) {
}
