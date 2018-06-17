package com.countrycinema.ua.dto.film.actor;

import com.countrycinema.ua.common.enums.Gender;
import com.countrycinema.ua.dto.core.IdDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActorRequestDTO extends IdDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("age")
    private int age;
    @JsonProperty("filmId")
    private Long filmId;

}
