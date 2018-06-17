package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.film.Actor;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends OptionalRepository<Actor, Long> {
}
