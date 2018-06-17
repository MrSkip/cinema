package com.countrycinema.ua.service;

import com.countrycinema.ua.dto.film.FilmRequestDTO;
import com.countrycinema.ua.dto.film.FilmResponseDTO;
import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.service.core.ServiceCore;
import com.countrycinema.ua.service.core.rest.RestService;

public interface FilmService extends RestService<FilmRequestDTO, FilmResponseDTO>,
        ServiceCore<Film, Long> {


}
