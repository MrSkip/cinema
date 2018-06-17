package com.countrycinema.ua.dto.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IdDTO {

    @JsonProperty("id")
    protected Long id;

}
