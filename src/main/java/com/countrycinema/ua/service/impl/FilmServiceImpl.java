package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.FilmRequestDTO;
import com.countrycinema.ua.dto.film.FilmResponseDTO;
import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import com.countrycinema.ua.service.FilmService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl extends ServiceCoreImpl<Film, Long> implements FilmService {
    private final ModelMapper modelMapper;

    @Autowired
    public FilmServiceImpl(OptionalRepository<Film, Long> repository, ModelMapper modelMapper) {
        super(repository);
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public FilmResponseDTO save(FilmRequestDTO dto) {
        if (dto.getId() == null) {
            Film film = modelMapper.map(dto, Film.class);
            repository.save(film);
            return modelMapper.map(film, FilmResponseDTO.class);
        }

        Film persistedFilm = getOne(dto.getId());
        persistedFilm.fetch(dto);

        return modelMapper.map(persistedFilm, FilmResponseDTO.class);
    }

    @Override
    @Transactional
    public FilmResponseDTO findOne(Long id) {
        return modelMapper.map(getOne(id), FilmResponseDTO.class);
    }

    @Override
    @Transactional
    public MessageDTO delete(Long id) {
        return deleteOne(id);
    }

    @Override
    @Transactional
    public List<FilmResponseDTO> findAll() {
        List<Film> list = repository.findAll();
        return modelMapper.map(list, List.class);
    }
}
