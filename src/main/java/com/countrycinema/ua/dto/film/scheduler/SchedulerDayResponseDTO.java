package com.countrycinema.ua.dto.film.scheduler;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class SchedulerDayResponseDTO {

    private LocalDate day;
    private List<FilmScheduleResponseDTO> times;

    public SchedulerDayResponseDTO(LocalDate localDate) {
        day = localDate;
        times = new ArrayList<>();
    }
}
