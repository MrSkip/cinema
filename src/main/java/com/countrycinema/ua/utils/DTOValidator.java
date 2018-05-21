package com.countrycinema.ua.utils;

import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;

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
}
