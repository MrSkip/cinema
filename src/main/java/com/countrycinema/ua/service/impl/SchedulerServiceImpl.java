package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.scheduler.FilmScheduleResponseDTO;
import com.countrycinema.ua.dto.film.scheduler.FilmSchedulerRequestDTO;
import com.countrycinema.ua.dto.film.scheduler.SchedulerDayResponseDTO;
import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.persistence.entity.schedule.FilmSchedule;
import com.countrycinema.ua.persistence.repository.FilmScheduleRepository;
import com.countrycinema.ua.service.FilmService;
import com.countrycinema.ua.service.SchedulerService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchedulerServiceImpl extends ServiceCoreImpl<FilmSchedule, Long> implements SchedulerService {
    private final ModelMapper modelMapper;
    private final FilmService filmService;
    private final FilmScheduleRepository repository;

    public SchedulerServiceImpl(ModelMapper modelMapper, FilmService filmService,
                                FilmScheduleRepository repository) {
        super(repository);
        this.modelMapper = modelMapper;
        this.filmService = filmService;
        this.repository = repository;
    }

    @Override
    public List<SchedulerDayResponseDTO> todaysHits() {
        List<FilmSchedule> schedules
                = repository.findAllByStartedAt(LocalDate.now().atStartOfDay());
        List<SchedulerDayResponseDTO> days = new ArrayList<>();

        if (CollectionUtils.isEmpty(schedules)) {
            return Collections.EMPTY_LIST;
        }
        schedules.forEach(schedule -> {
            FilmScheduleResponseDTO dto = new FilmScheduleResponseDTO(schedule);

            if (days.isEmpty()) {
                SchedulerDayResponseDTO day
                        = new SchedulerDayResponseDTO(schedule.getStartedAt().toLocalDate());
                day.getTimes().add(dto);
                days.add(day);
            } else if (days.get(days.size() - 1).getDay().equals(schedule.getStartedAt().toLocalDate())) {
                days.get(days.size() - 1).getTimes().add(dto);
            } else {
                SchedulerDayResponseDTO day
                        = new SchedulerDayResponseDTO(schedule.getStartedAt().toLocalDate());
                day.getTimes().add(dto);
                days.add(day);
            }
        });

        return days;
    }

    @Override
    public FilmScheduleResponseDTO save(FilmSchedulerRequestDTO dto) {
//        DTOValidator.validate(dto);
        Film film = filmService.getOne(dto.getFilmId());

        if (dto.getId() == null) {
            FilmSchedule filmSchedule = modelMapper.map(dto, FilmSchedule.class);
            repository.save(filmSchedule.setFilm(film));
            return new FilmScheduleResponseDTO(filmSchedule);
        }

        FilmSchedule persisted = getOne(dto.getId()).setFilm(film);
        persisted.fetch(dto);

        return new FilmScheduleResponseDTO(persisted);
    }

    @Override
    public FilmScheduleResponseDTO findOne(Long id) {
        return new FilmScheduleResponseDTO(getOne(id));
    }

    @Override
    public MessageDTO delete(Long id) {
        return deleteOne(id);
    }

    @Override
    public List<FilmScheduleResponseDTO> findAll() {
        List<FilmSchedule> list = repository.findAll();
        List<FilmScheduleResponseDTO> collect
                = list.stream().map(FilmScheduleResponseDTO::new).collect(Collectors.toList());
        return collect;
    }
}
