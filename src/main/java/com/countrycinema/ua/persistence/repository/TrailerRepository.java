package com.countrycinema.ua.persistence.repository;

import com.countrycinema.ua.persistence.entity.film.Trailer;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerRepository extends OptionalRepository<Trailer, Long> {
}
