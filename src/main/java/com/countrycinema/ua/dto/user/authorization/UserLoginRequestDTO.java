package com.countrycinema.ua.dto.user.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLoginRequestDTO {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

}
