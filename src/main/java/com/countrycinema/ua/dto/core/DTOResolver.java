package com.countrycinema.ua.dto.core;

import com.countrycinema.ua.persistence.entity._core.id.IdComponent;
import lombok.Data;

@Data
public class DTOResolver<T extends IdComponent> {
    private T model;
    private Object dto;

    public DTOResolver(T model, Object dto) {
        this.model = model;
        this.dto = dto;
    }


}
