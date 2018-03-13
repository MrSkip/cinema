package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import com.countrycinema.ua.service.UserService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceCoreImpl<User, Long> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }



}
