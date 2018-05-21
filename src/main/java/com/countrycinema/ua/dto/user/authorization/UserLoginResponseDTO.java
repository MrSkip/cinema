package com.countrycinema.ua.dto.user.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLoginResponseDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("role")
    private String role;

}
