package com.countrycinema.ua.controller;

import com.countrycinema.ua.dto.user.UserResponseDTO;
import com.countrycinema.ua.persistence.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public UserResponseDTO forTest() {
        User user = new User();

        return modelMapper.map(user, UserResponseDTO.class);
    }
}
