package com.countrycinema.ua.dto.film.trailer;

import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrailerRequestDTO extends IdDTO {

    @JsonProperty("filmId")
    private Long filmId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("link")
    private String link;

}
