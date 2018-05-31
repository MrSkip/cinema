package com.countrycinema.ua.dto.user.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"password"})
@EqualsAndHashCode(exclude = {"password"})
public class UserLoginRequestDTO {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public UserLoginRequestDTO() {
    }

    public UserLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
