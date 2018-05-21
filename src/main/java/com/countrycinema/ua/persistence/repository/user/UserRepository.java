package com.countrycinema.ua.persistence.repository.user;

import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends OptionalRepository<User, String> {

    void customThing();

    Optional<User> findOneByEmail(String email);

    List<User> findAllByCompanyId(String id);


}
