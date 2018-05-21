package com.countrycinema.ua.controller.api;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginResponseDTO;
import com.countrycinema.ua.dto.user.authorization.UserRequestNewPassDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;
import com.countrycinema.ua.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/public")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO loginDTO) {
        return authorizationService.login(loginDTO);
    }

    @GetMapping("/logout")
    public MessageDTO logout() {
        return authorizationService.logout();
    }

    @PostMapping("/forgot-password")
    public MessageDTO login(@RequestBody UserRequestNewPassDTO newPassDTO) {
        return authorizationService.requestNewPassword(newPassDTO);
    }

    @PostMapping("/approve-forgotten-password")
    public MessageDTO login(@RequestBody UserResetPassDTO resetPassDTO) {
        return authorizationService.submitForgottenPassword(resetPassDTO);
    }

}
