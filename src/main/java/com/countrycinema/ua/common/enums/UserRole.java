package com.countrycinema.ua.common.enums;

import com.countrycinema.ua.exception.BadInputParamException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserRole {

    SUPER_ADMIN("Super admin"),
    COMPANY_ADMIN("Company admin"),
    CONTENT_MAKER("Content maker"),
    USER("User");

    private String name;

    UserRole(String name) {
        this.name = name;
    }

    @JsonCreator
    public static UserRole softInstanceOf(String name) {
        if (name == null) {
            throw new BadInputParamException();
        }
        switch (name) {
            case "SUPER_ADMIN":
                return SUPER_ADMIN;
            case "COMPANY_ADMIN":
                return COMPANY_ADMIN;
            case "CONTENT_MAKER":
                return CONTENT_MAKER;
            case "USER":
                return USER;
        }

        throw new BadInputParamException();
    }

    public String getName() {
        return name;
    }

}
