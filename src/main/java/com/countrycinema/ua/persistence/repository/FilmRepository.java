package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends OptionalRepository<Film, Long> {
}
