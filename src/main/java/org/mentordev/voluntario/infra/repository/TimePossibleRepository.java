package org.mentordev.voluntario.infra.repository;

import org.mentordev.voluntario.domain.model.TimePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface TimePossibleRepository extends JpaRepository<TimePossible, Long> {

}
