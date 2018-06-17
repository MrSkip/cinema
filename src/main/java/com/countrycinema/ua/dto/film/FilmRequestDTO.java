package com.countrycinema.ua.dto.film;

import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmRequestDTO extends IdDTO {

    //    @JsonProperty("id")
//    private Long id;
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

}
