package com.countrycinema.ua.service.core.rest;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.dto.core.IdDTO;

import java.util.List;

public interface RestService<Request extends IdDTO, Response extends IdDTO> {

    Response save(Request dto);

    Response findOne(Long id);

    MessageDTO delete(Long id);

    List<Response> findAll();

}
