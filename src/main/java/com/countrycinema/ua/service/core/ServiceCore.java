package com.countrycinema.ua.service.core;

import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.persistence.entity._core.id.IdComponent;

public interface ServiceCore<E extends IdComponent, ID> {

    E getOne(ID id);

    MessageDTO deleteOne(ID id);

}
