package com.countrycinema.ua.controller;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.FilmRequestDTO;
import com.countrycinema.ua.dto.film.FilmResponseDTO;
import com.countrycinema.ua.service.FilmService;
import com.countrycinema.ua.service.core.rest.RestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController implements RestService<FilmRequestDTO, FilmResponseDTO> {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @Override
    @PostMapping("public/films")
    public FilmResponseDTO save(@RequestBody FilmRequestDTO dto) {
        return filmService.save(dto);
    }

    @Override
    @GetMapping("public/films/{id}")
    public FilmResponseDTO findOne(@PathVariable("id") Long id) {
        return filmService.findOne(id);
    }

    @Override
    @DeleteMapping("public/films/{id}")
    public MessageDTO delete(@PathVariable("id") Long id) {
        return filmService.delete(id);
    }

    @Override
    @GetMapping("public/films")
    public List<FilmResponseDTO> findAll() {
        return filmService.findAll();
    }

}
