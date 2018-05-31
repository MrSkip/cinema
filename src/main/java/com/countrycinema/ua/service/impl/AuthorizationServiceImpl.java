package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.common.Logger;
import com.countrycinema.ua.component.MailComponent;
import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.mail.MailDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginRequestDTO;
import com.countrycinema.ua.dto.user.authorization.UserLoginResponseDTO;
import com.countrycinema.ua.dto.user.authorization.UserRequestNewPassDTO;
import com.countrycinema.ua.dto.user.authorization.UserResetPassDTO;
import com.countrycinema.ua.dto.user.registration.UserRegistrationDTO;
import com.countrycinema.ua.exception.BadInputParamException;
import com.countrycinema.ua.persistence.entity.Token;
import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.TokenRepository;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import com.countrycinema.ua.service.AuthorizationService;
import com.countrycinema.ua.utils.DTOValidator;
import com.countrycinema.ua.utils.SecurityUtil;
import com.countrycinema.ua.utils.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private static final String CHECK_THE_USER_CREDENTIALS = "Please check the user credentials";
    private static final int TOKEN_EXPIRED = 3;// hours

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private MailComponent mailComponent;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private ModelMapper modelMapper;

    private static void checkPassportsIdentity(String firstPass, String secondPass) {
        if (!Objects.equals(firstPass, secondPass)) {
            throw new BadInputParamException("Passwords didn't match");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserLoginResponseDTO login(UserLoginRequestDTO loginDTO) {
        DTOValidator.validate(loginDTO);
        User user = userRepository.findOneByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new BadInputParamException(CHECK_THE_USER_CREDENTIALS));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            Logger.error("Failed to authenticate : " + loginDTO.getEmail());
            throw new BadInputParamException(CHECK_THE_USER_CREDENTIALS);
        }

        return createSpringSession(loginDTO, user);
    }

    private UserLoginResponseDTO createSpringSession(UserLoginRequestDTO loginDTO, User user) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginDTO.getEmail().trim(), loginDTO.getPassword());
        Authentication authentication;
        try {
            authentication = this.authManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            Logger.error("Failed to authenticate : " + loginDTO.getEmail(), e);
            throw new BadInputParamException(CHECK_THE_USER_CREDENTIALS);
        }
        return transformAuthenticationToAuthUserDTO(authentication, user);
    }

    private UserLoginResponseDTO transformAuthenticationToAuthUserDTO(Authentication authentication, User user) {
        if (authentication == null) {
            throw new BadInputParamException(CHECK_THE_USER_CREDENTIALS);
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof String && principal.equals("anonymousUser")) {
            throw new BadInputParamException(CHECK_THE_USER_CREDENTIALS);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return modelMapper.map(user, UserLoginResponseDTO.class);
    }

    @Override
    public MessageDTO logout() {
        SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(null);
        return MessageDTO.of("Logout successfully");
    }

    @Override
    @Transactional
    public MessageDTO requestNewPassword(UserRequestNewPassDTO newPassDTO) {
        Validator
                .validate(newPassDTO.getEmail())
                .withException("Email could not be empty");
        User user = userRepository
                .findOneByEmail(newPassDTO.getEmail())
                .orElseThrow(() -> new BadInputParamException("No such user exception"));

        if (user.getToken() != null) {
            user.setToken(null);
        }

        Token token = new Token()
                .setToken(SecurityUtil.getRandomSecretKey())
                .setUser(user);
        tokenRepository.save(token);

        mailComponent.asyncSendMail(
                MailDTO.asRawText("Request new pass", token.getToken(), user.getEmail()));
        return MessageDTO.of("Check your email");
    }

    @Override
    @Transactional(noRollbackFor = BadInputParamException.class)
    public MessageDTO submitForgottenPassword(UserResetPassDTO resetPassDTO) {
        DTOValidator.validate(resetPassDTO);
        checkPassportsIdentity(resetPassDTO.getPassword(), resetPassDTO.getRepeatPassword());

        String message = "Could not reset password. Please submit a new reset password request";
        Token token = tokenRepository
                .findOneByToken(resetPassDTO.getToken())
                .orElseThrow(() -> new BadInputParamException(message));

        if (LocalDateTime.now().minusHours(TOKEN_EXPIRED)
                .compareTo(token.getCreatedTime()) < 0) {
            token.getUser().setToken(null);
            throw new BadInputParamException(message);
        }

        User user = token.getUser()
                .setPassword(passwordEncoder.encode(resetPassDTO.getPassword()))
                .setToken(null);
        userRepository.save(user);

        mailComponent.asyncSendMail(
                MailDTO.asRawText("Password changed", "Changed", user.getEmail()));
        return MessageDTO.of("The password has been updated");
    }

    @Override
    @Transactional
    public UserLoginResponseDTO finishRegistration(UserResetPassDTO dto) {
        DTOValidator.validate(dto);
        checkPassportsIdentity(dto.getPassword(), dto.getRepeatPassword());

        String message = "Registration failed";
        Token token = tokenRepository
                .findOneByToken(dto.getToken())
                .orElseThrow(() -> new BadInputParamException(message));

        User user = token.getUser()
                .setPassword(passwordEncoder.encode(dto.getPassword()))
                .setActivated(true)
                .setToken(null);
        userRepository.save(user);

        return login(new UserLoginRequestDTO(user.getEmail(), dto.getPassword()));
    }

    @Override
    @Transactional
    public MessageDTO signUp(UserRegistrationDTO dto) {
        DTOValidator.validate(dto);

        if (userRepository.findOneByEmail(dto.getEmail()).isPresent()) {
            throw new BadInputParamException("You could not create user with such email");
        }

        String key = SecurityUtil.getRandomSecretKey();
        User mappedUser = modelMapper.map(dto, User.class).setPassword(key);

        userRepository.save(mappedUser);
        tokenRepository.save(new Token(key).setUser(mappedUser));

        mailComponent.asyncSendMail(
                MailDTO.asRawText("Finish your registration", key, mappedUser.getEmail()));
        return MessageDTO.of("Check out your email and finish the registration");
    }

}
