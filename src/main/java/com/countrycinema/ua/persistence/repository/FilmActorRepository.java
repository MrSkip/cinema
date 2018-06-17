package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.film.FilmActor;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends OptionalRepository<FilmActor, Long> {
}
