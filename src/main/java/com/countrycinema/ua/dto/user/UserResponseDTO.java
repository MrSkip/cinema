package com.countrycinema.ua.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResponseDTO {

    @JsonProperty("usernameFromJson")
    private String username;

}
