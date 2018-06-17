package com.countrycinema.ua.dto.film.format;

import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormatResponseDTO extends IdDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;

}
