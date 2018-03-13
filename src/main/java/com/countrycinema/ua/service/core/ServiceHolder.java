package com.countrycinema.ua.service.core;

import com.countrycinema.ua.persistence.entity.core.id.IdComponent;
import com.countrycinema.ua.persistence.repository.core.OptionalRepository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ServiceHolder<E extends IdComponent, ID> {

    private static ConcurrentMap<Class,? extends OptionalRepository> repositories;
    private static ConcurrentMap<Class,? extends ServiceCoreImpl> services;

    static {
        repositories = new ConcurrentHashMap<>();
        services = new ConcurrentHashMap<>();
    }

    public ServiceHolder(OptionalRepository<E, ID> repository, ServiceCore service) {

    }

}
