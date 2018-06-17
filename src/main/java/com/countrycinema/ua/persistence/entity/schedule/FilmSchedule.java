package com.countrycinema.ua.persistence.entity.schedule;

import com.countrycinema.ua.dto.film.scheduler.FilmSchedulerRequestDTO;
import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import com.countrycinema.ua.persistence.entity.film.Film;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedulers")
@Data
@ToString(callSuper = true, exclude = {"film", "technology"})
@EqualsAndHashCode(callSuper = true, exclude = {"film", "technology"})
public class FilmSchedule extends IdComponentLong<FilmSchedule> {

    @Column(name = "startedAt")
    private LocalDateTime startedAt;
    @Column(name = "available", columnDefinition = "boolean default true")
    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technology technology;

    public void fetch(FilmSchedulerRequestDTO dto) {
        startedAt = dto.getStartedAt();
    }
}
