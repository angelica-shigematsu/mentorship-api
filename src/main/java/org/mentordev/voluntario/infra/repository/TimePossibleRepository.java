package org.mentordev.voluntario.infra.repository;

import org.mentordev.voluntario.domain.dto.TimePossibleDTO;
import org.mentordev.voluntario.domain.model.TimePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimePossibleRepository extends JpaRepository<TimePossible, Long> {

    @Query("""
            SELECT new org.mentordev.voluntario.domain.dto.TimePossibleDTO(tp.id, tp.dayOfWeek, tp.startTime,tp.endTime)
                FROM TimePossible tp
             WHERE tp.user.id = :mentorId AND tp.dayOfWeek = :dayOfWeek""")
    List<TimePossibleDTO> findAllByDayWeek(String dayOfWeek, long mentorId);
}
