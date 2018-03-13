package com.countrycinema.ua.persistence.repository.user;

import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends OptionalRepository<User, Long> {

    void customThing();

}
