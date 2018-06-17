package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.film.FilmPoster;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository extends OptionalRepository<FilmPoster, Long> {
}
