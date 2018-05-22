package com.countrycinema.ua.config.security;

import com.countrycinema.ua.common.Logger;
import com.countrycinema.ua.common.enums.UserRole;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Logger.info("Attempt to load user by email " + email);
        com.countrycinema.ua.persistence.entity.User userFromDB = userRepository.findOneByEmail(email)
                .orElseThrow(() -> new BadCredentialsException(email));

        UserRole role = userFromDB.getRole();
        final Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return new User(userFromDB.getEmail(), userFromDB.getPassword(), userFromDB.isActivated(),
                true, true, true, authorities);
    }
}

