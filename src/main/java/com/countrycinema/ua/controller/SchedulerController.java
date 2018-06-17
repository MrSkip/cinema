package com.countrycinema.ua.controller;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.scheduler.FilmScheduleResponseDTO;
import com.countrycinema.ua.dto.film.scheduler.FilmSchedulerRequestDTO;
import com.countrycinema.ua.dto.film.scheduler.SchedulerDayResponseDTO;
import com.countrycinema.ua.service.SchedulerService;
import com.countrycinema.ua.service.core.rest.RestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchedulerController implements RestService<FilmSchedulerRequestDTO, FilmScheduleResponseDTO> {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping("public/schedulers/todays-hits")
    public List<SchedulerDayResponseDTO> todaysHits() {
        return schedulerService.todaysHits();
    }

    @Override
    @PostMapping("public/schedulers")
    public FilmScheduleResponseDTO save(@RequestBody FilmSchedulerRequestDTO dto) {
        return schedulerService.save(dto);
    }

    @Override
    @GetMapping("public/schedulers/{id}")
    public FilmScheduleResponseDTO findOne(Long id) {
        return schedulerService.findOne(id);
    }

    @Override
    @DeleteMapping("public/schedulers/{id}")
    public MessageDTO delete(Long id) {
        return schedulerService.delete(id);
    }

    @Override
    @GetMapping("public/schedulers")
    public List<FilmScheduleResponseDTO> findAll() {
        return schedulerService.findAll();
    }
}
