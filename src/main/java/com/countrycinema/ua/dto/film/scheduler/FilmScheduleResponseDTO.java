package com.countrycinema.ua.dto.film.scheduler;

import com.countrycinema.ua.dto.core.IdDTO;
import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.persistence.entity.schedule.FilmSchedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmScheduleResponseDTO extends IdDTO {

    @JsonProperty("time")
    private LocalTime time;
    @JsonProperty("available")
    private boolean available;
    @JsonProperty("filmId")
    private Long filmId;

    public FilmScheduleResponseDTO() {
    }

    public FilmScheduleResponseDTO(FilmSchedule schedule) {
        id = schedule.getId();
        time = schedule.getStartedAt().toLocalTime();
        available = schedule.isAvailable();
        filmId = schedule.getFilm().getId();
    }
}
