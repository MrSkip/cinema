package com.countrycinema.ua.persistence.entity.core.id;

import com.countrycinema.ua.dto.core.DTOResolver;

public interface IdComponent<T1, T2 extends IdComponent> {

    T1 getId();
    T2 setId(T1 id);

    T2 obtainEntity();

    default DTOResolver<T2> toDTO(Object dto) {
        return new DTOResolver<>(obtainEntity(), dto);
    }
}
