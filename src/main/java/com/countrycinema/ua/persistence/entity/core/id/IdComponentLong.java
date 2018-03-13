package com.countrycinema.ua.persistence.entity.core.id;

import javax.persistence.*;

@MappedSuperclass
public class IdComponentLong<T extends IdComponentLong> implements IdComponent<Long, T> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public T setId(Long id) {
        return obtainEntity();
    }

    @Override
    @SuppressWarnings("all")
    public T obtainEntity() {
        return (T) this;
    }
}
