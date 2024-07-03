package org.mentordev.voluntario.service.profile;

import org.mentordev.voluntario.domain.dto.ListProfileDTO;
import org.mentordev.voluntario.domain.model.Profile;
import org.mentordev.voluntario.infra.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImplement implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ListProfileDTO add(Profile profile) {

        if (profile.getUser().getRole().toString().equalsIgnoreCase("MENTOR")) {
            profile.setExpert(profile.getExpertise());
        } else {
            profile.setExpert(null);
        }
        var profileCreated = profileRepository.save(profile);

        return new ListProfileDTO(profileCreated.getId(),
                profileCreated.getBio(),
                profileCreated.getExpertise(),
                profileCreated.getUser());
    }
}
