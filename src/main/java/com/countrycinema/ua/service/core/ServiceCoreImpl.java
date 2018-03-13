package com.countrycinema.ua.service.core;

import com.countrycinema.ua.exception.ObjectNotFoundException;
import com.countrycinema.ua.persistence.entity.core.id.IdComponent;
import com.countrycinema.ua.persistence.repository.core.OptionalRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

public class ServiceCoreImpl<E extends IdComponent, ID> implements ServiceCore<E, ID> {
    public static final String ID_IS_NULL = "Id is invalid";

    private final OptionalRepository<E, ID> repository;

    public ServiceCoreImpl(OptionalRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public E getOne(ID id) {
        Objects.requireNonNull(id, ID_IS_NULL);
        Optional<E> record = repository.findById(id);
        return record.orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public void delete(ID id) {
        E record = getOne(id);
        repository.delete(record);
    }

}
