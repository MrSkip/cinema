package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.schedule.FilmSchedule;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FilmScheduleRepository extends OptionalRepository<FilmSchedule, Long> {

    @Query("select f from FilmSchedule f where f.startedAt >= ?1")
    List<FilmSchedule> findAllByStartedAt(LocalDateTime startOfDay);

}
