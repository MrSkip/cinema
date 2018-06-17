package com.countrycinema.ua.dto.film;

import com.countrycinema.ua.dto.core.IdDTO;
import com.countrycinema.ua.dto.film.actor.ActorResponseDTO;
import com.countrycinema.ua.dto.film.format.FormatResponseDTO;
import com.countrycinema.ua.dto.film.poster.PosterResponseDTO;
import com.countrycinema.ua.dto.film.scheduler.SchedulerDayResponseDTO;
import com.countrycinema.ua.dto.film.technology.TechnologyResponseDTO;
import com.countrycinema.ua.dto.film.trailer.TrailerResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmResponseDTO extends IdDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("year")
    private int year;
    @JsonProperty("country")
    private String country;
    @JsonProperty("releasedAt")
    private LocalDate releasedAt;
    @JsonProperty("duration")
    private int duration;
    @JsonProperty("ageFrom")
    private int ageFrom;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("text")
    private String text;

    @JsonProperty("producers")
    private List<ActorResponseDTO> producers;
    @JsonProperty("actors")
    private List<ActorResponseDTO> actors;
    @JsonProperty("trailers")
    private List<TrailerResponseDTO> trailers;
    @JsonProperty("posters")
    private List<PosterResponseDTO> posters;
    @JsonProperty("formats")
    private List<FormatResponseDTO> formats;
    @JsonProperty("technologies")
    private List<TechnologyResponseDTO> technologies;

    private List<SchedulerDayResponseDTO> schedules;
}
