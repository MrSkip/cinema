package com.countrycinema.ua.utils;

import com.countrycinema.ua.dto.film.trailer.TrailerRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;
import com.countrycinema.ua.dto.user.registration.UserRegistrationDTO;

public class DTOValidator {

    private static final String ALL_FIELDS_REQUIRED = "Please fill out all the mandatory fields";

    public static void validate(UserLoginRequestDTO dto) {
        Validator
                .validate(dto.getEmail(), dto.getPassword())
                .withException("Password or email didn't match");
    }

    public static void validate(UserResetPassDTO dto) {
        Validator
                .validate(dto.getPassword(), dto.getRepeatPassword(), dto.getToken())
                .withException(ALL_FIELDS_REQUIRED);
    }

    public static void validate(UserRegistrationDTO dto) {
        Validator
                .validate(
                        dto.getEmail(), dto.getFirstName(), dto.getLastName())
                .withCheck(dto.getDateOfBorn(), dto.getGender())
                .withException(ALL_FIELDS_REQUIRED);
    }

    public static void validate(TrailerRequestDTO dto) {
//        Validator.validate(dto.g)
    }
}
