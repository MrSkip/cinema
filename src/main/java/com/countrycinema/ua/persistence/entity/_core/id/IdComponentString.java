package com.countrycinema.ua.persistence.entity._core.id;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
public class IdComponentString<T extends IdComponentString> implements IdComponent<String, T> {

    @Id
    @Column(name = "id")
    protected String id;

    public IdComponentString() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public T setId(String id) {
        return obtainEntity();
    }

    @PrePersist
    protected void prePersist() {
        id = UUID.randomUUID().toString();
    }

    @Override
    @SuppressWarnings("all")
    public T obtainEntity() {
        return (T) this;
    }

}
