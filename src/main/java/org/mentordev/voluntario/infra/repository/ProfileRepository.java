package org.mentordev.voluntario.infra.repository;

import org.mentordev.voluntario.domain.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
