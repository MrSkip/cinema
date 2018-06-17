package com.countrycinema.ua.service;

import com.countrycinema.ua.dto.film.scheduler.FilmScheduleResponseDTO;
import com.countrycinema.ua.dto.film.scheduler.FilmSchedulerRequestDTO;
import com.countrycinema.ua.dto.film.scheduler.SchedulerDayResponseDTO;
import com.countrycinema.ua.service.core.rest.RestService;

import java.util.List;

public interface SchedulerService extends RestService<FilmSchedulerRequestDTO, FilmScheduleResponseDTO> {

    List<SchedulerDayResponseDTO> todaysHits();

}
