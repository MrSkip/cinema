package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.film.trailer.TrailerRequestDTO;
import com.countrycinema.ua.dto.film.trailer.TrailerResponseDTO;
import com.countrycinema.ua.persistence.entity.film.Film;
import com.countrycinema.ua.persistence.entity.film.Trailer;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import com.countrycinema.ua.service.FilmService;
import com.countrycinema.ua.service.TrailerService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import com.countrycinema.ua.utils.DTOValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrailerServiceImpl extends ServiceCoreImpl<Trailer, Long> implements TrailerService {
    private final ModelMapper modelMapper;
    private final FilmService filmService;

    public TrailerServiceImpl(OptionalRepository<Trailer, Long> repository, ModelMapper modelMapper, FilmService filmService) {
        super(repository);
        this.modelMapper = modelMapper;
        this.filmService = filmService;
    }

    @Override
    public TrailerResponseDTO save(TrailerRequestDTO dto) {
        DTOValidator.validate(dto);
        Film film = filmService.getOne(dto.getFilmId());

        if (dto.getId() == null) {
            Trailer trailer = modelMapper.map(dto, Trailer.class);
            repository.save(trailer.setFilm(film));
            return modelMapper.map(trailer, TrailerResponseDTO.class);
        }

        Trailer persisted = getOne(dto.getId()).setFilm(film);
        persisted.fetch(dto);

        return modelMapper.map(persisted, TrailerResponseDTO.class);
    }

    @Override
    public TrailerResponseDTO findOne(Long id) {
        return modelMapper.map(getOne(id), TrailerResponseDTO.class);
    }

    @Override
    public MessageDTO delete(Long id) {
        return deleteOne(id);
    }

    @Override
    public List<TrailerResponseDTO> findAll() {
        List<Trailer> list = repository.findAll();
        return modelMapper.map(list, List.class);
    }
}
