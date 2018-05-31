package com.countrycinema.ua.dto.user.registration;

import com.countrycinema.ua.common.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegistrationDTO {

    @JsonProperty("username")
    public String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dateOfBorn")
    private LocalDate dateOfBorn;
    @JsonProperty("gender")
    private Gender gender;
}
