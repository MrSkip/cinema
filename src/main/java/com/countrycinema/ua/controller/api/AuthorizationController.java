package com.countrycinema.ua.controller.api;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginResponseDTO;
import com.countrycinema.ua.dto.user.authorization.UserRequestNewPassDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;
import com.countrycinema.ua.dto.user.registration.UserRegistrationDTO;
import com.countrycinema.ua.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("public/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO loginDTO) {
        return authorizationService.login(loginDTO);
    }

    @GetMapping("protected/logout")
    public MessageDTO logout() {
        return authorizationService.logout();
    }

    @PostMapping("public/forgot-password")
    public MessageDTO login(@RequestBody UserRequestNewPassDTO newPassDTO) {
        return authorizationService.requestNewPassword(newPassDTO);
    }

    @PostMapping("public/approve-forgotten-password")
    public MessageDTO login(@RequestBody UserResetPassDTO resetPassDTO) {
        return authorizationService.submitForgottenPassword(resetPassDTO);
    }

    @PostMapping("public/sign-up")
    public MessageDTO signUp(@RequestBody UserRegistrationDTO dto) {
        return authorizationService.signUp(dto);
    }

    @PostMapping("public/finish-up-registration")
    public UserLoginResponseDTO finishRegistration(@RequestBody UserResetPassDTO resetPassDTO) {
        return authorizationService.finishRegistration(resetPassDTO);
    }

}
