package com.countrycinema.ua.controller;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.actor.ActorRequestDTO;
import com.countrycinema.ua.dto.film.actor.ActorResponseDTO;
import com.countrycinema.ua.service.ActorService;
import com.countrycinema.ua.service.core.rest.RestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController implements RestService<ActorRequestDTO, ActorResponseDTO> {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    @PostMapping("public/actors")
    public ActorResponseDTO save(@RequestBody ActorRequestDTO dto) {
        return actorService.save(dto);
    }

    @Override
    @GetMapping("public/actors/{id}")
    public ActorResponseDTO findOne(@PathVariable("id") Long id) {
        return actorService.findOne(id);
    }

    @Override
    @DeleteMapping("public/actors/{id}")
    public MessageDTO delete(@PathVariable("id") Long id) {
        return actorService.delete(id);
    }

    @Override
    @GetMapping("public/actors")
    public List<ActorResponseDTO> findAll() {
        return actorService.findAll();
    }
}
