package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.Token;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends OptionalRepository<Token, Long> {

    Optional<Token> findOneByToken(String token);

}
