package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.actor.ActorRequestDTO;
import com.countrycinema.ua.dto.film.actor.ActorResponseDTO;
import com.countrycinema.ua.persistence.entity.film.Actor;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import com.countrycinema.ua.service.ActorService;
import com.countrycinema.ua.service.FilmService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorServiceImpl extends ServiceCoreImpl<Actor, Long> implements ActorService {
    private final ModelMapper modelMapper;
    private final FilmService filmService;

    public ActorServiceImpl(OptionalRepository<Actor, Long> repository, ModelMapper modelMapper, FilmService filmService) {
        super(repository);
        this.modelMapper = modelMapper;
        this.filmService = filmService;
    }

    @Override
    public ActorResponseDTO save(ActorRequestDTO dto) {
        if (dto.getId() == null) {
            Actor actor = modelMapper.map(dto, Actor.class);
            repository.save(actor);
            return modelMapper.map(actor, ActorResponseDTO.class);
        }

        Actor persisted = getOne(dto.getId());

        persisted.fetch(dto);

        return modelMapper.map(persisted, ActorResponseDTO.class);
    }

    @Override
    public ActorResponseDTO findOne(Long id) {
        return modelMapper.map(getOne(id), ActorResponseDTO.class);
    }

    @Override
    public MessageDTO delete(Long id) {
        return deleteOne(id);
    }

    @Override
    public List<ActorResponseDTO> findAll() {
        List<Actor> list = repository.findAll();
        return modelMapper.map(list, List.class);
    }
}
