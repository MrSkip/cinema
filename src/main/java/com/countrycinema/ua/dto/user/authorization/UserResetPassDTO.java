package com.countrycinema.ua.dto.user.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResetPassDTO {

    @JsonProperty("token")
    private String token;
    @JsonProperty("password")
    private String password;
    @JsonProperty("repeatPassword")
    private String repeatPassword;

}
