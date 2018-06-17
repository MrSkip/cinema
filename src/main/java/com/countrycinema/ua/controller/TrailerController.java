package com.countrycinema.ua.controller;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.trailer.TrailerRequestDTO;
import com.countrycinema.ua.dto.film.trailer.TrailerResponseDTO;
import com.countrycinema.ua.service.TrailerService;
import com.countrycinema.ua.service.core.rest.RestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrailerController implements RestService<TrailerRequestDTO, TrailerResponseDTO> {

    private final TrailerService trailerService;

    public TrailerController(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @Override
    @PostMapping("public/trailers")
    public TrailerResponseDTO save(@RequestBody TrailerRequestDTO dto) {
        return trailerService.save(dto);
    }

    @Override
    @GetMapping("public/trailers/{id}")
    public TrailerResponseDTO findOne(@PathVariable("id") Long id) {
        return trailerService.findOne(id);
    }

    @Override
    @DeleteMapping("public/trailers/{id}")
    public MessageDTO delete(@PathVariable("id") Long id) {
        return trailerService.delete(id);
    }

    @Override
    @GetMapping("public/trailers")
    public List<TrailerResponseDTO> findAll() {
        return trailerService.findAll();
    }
}
