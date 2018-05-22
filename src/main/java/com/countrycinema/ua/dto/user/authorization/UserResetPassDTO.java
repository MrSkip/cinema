package com.countrycinema.ua.dto.user.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"password", "repeatPassword"})
@EqualsAndHashCode(exclude = {"password", "repeatPassword"})
public class UserResetPassDTO {

    @JsonProperty("token")
    private String token;
    @JsonProperty("password")
    private String password;
    @JsonProperty("repeatPassword")
    private String repeatPassword;

}
