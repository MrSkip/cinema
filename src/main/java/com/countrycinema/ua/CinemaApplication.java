package com.countrycinema.ua;

import com.countrycinema.ua.persistence.repository.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    ApplicationRunner runner(UserRepository userRepository) {
        return (args) -> {

        };
    }
}
