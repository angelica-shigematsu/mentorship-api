package org.mentordev.voluntario.infra.repository;

import org.mentordev.voluntario.domain.model.TimePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimePossibleRepository extends JpaRepository<TimePossible, Long> {

    @Query("""
            SELECT tp
                FROM TimePossible tp
             WHERE tp.user.id = :mentorId AND tp.dayOfWeek = :dayOfWeek""")
    List<TimePossible> findAllByDayWeek(String dayOfWeek, long mentorId);
}
