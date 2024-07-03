package org.mentordev.voluntario.service.profile;

import org.mentordev.voluntario.domain.dto.ListProfileDTO;
import org.mentordev.voluntario.domain.model.Profile;

public interface ProfileService {

    ListProfileDTO add(Profile profile);
}
