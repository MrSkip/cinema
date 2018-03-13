package com.countrycinema.ua;

import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new User().setUsername("test").setPassword("er"));
            userRepository.customThing();
//            Optional<User> userOption = userRepository.findById(1L);
        };
    }
}
