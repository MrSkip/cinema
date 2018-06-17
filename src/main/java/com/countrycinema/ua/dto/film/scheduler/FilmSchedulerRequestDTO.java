package com.countrycinema.ua.dto.film.scheduler;

import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmSchedulerRequestDTO extends IdDTO {

    @JsonProperty("startedAt")
    private LocalDateTime startedAt;
    @JsonProperty("available")
    private boolean available;
    @JsonProperty("filmId")
    private Long filmId;

}
