package com.countrycinema.ua.dto.film.poster;

import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PosterResponseDTO extends IdDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("link")
    private String link;
    @JsonProperty("base64")
    private String base64;

}
