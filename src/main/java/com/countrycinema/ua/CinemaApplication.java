package com.countrycinema.ua;

import com.countrycinema.ua.common.enums.Gender;
import com.countrycinema.ua.common.enums.UserRole;
import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.company.CompanyRepository;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @PostConstruct
    void started() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    ApplicationRunner runner(UserRepository userRepository,
                             CompanyRepository companyRepository,
                             PasswordEncoder passwordEncoder) {
        return (args) -> {
            String userEmail = "dimon.mula@gmail.com";
            Company company = companyRepository.findOneByEmail(userEmail);
            if (company == null) {
                company = companyRepository.save(
                        new Company()
                                .setEmail(userEmail)
                                .setName("default")
                                .setTimeZone("UTC"));
            }
            User user = new User().setCompany(company);
            userRepository.findOneByEmail(userEmail)
                    .orElseGet(() -> userRepository.save(
                            user
                                    .setActivated(true)
                                    .setUsername("mrskip")
                                    .setDateOfBorn(LocalDate.now().minusYears(21))
                                    .setFirstName("дмитро")
                                    .setLastName("mula")
                                    .setGender(Gender.MALE)
                                    .setEmail(userEmail)
                                    .setRole(UserRole.SUPER_ADMIN)
                                    .setPassword(passwordEncoder.encode("qweqwe"))
                    ));
        };
    }
}
