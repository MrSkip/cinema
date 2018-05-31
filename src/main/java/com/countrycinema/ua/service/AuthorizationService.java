package com.countrycinema.ua.service;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginResponseDTO;
import com.countrycinema.ua.dto.user.authorization.UserRequestNewPassDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;
import com.countrycinema.ua.dto.user.registration.UserRegistrationDTO;

public interface AuthorizationService {

    UserLoginResponseDTO login(UserLoginRequestDTO loginDTO);

    MessageDTO logout();

    MessageDTO requestNewPassword(UserRequestNewPassDTO requestNewPassDTO);

    MessageDTO submitForgottenPassword(UserResetPassDTO resetPassDTO);

    MessageDTO signUp(UserRegistrationDTO dto);

    UserLoginResponseDTO finishRegistration(UserResetPassDTO resetPassDTO);
}
