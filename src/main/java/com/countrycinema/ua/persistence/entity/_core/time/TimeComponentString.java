package com.countrycinema.ua.persistence.entity._core.time;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public class TimeComponentString<T extends TimeComponentString> extends IdComponentString<T> implements TimeComponent {

    @Column(name = "createdTime", nullable = false, updatable = false)
    protected LocalDateTime createdTime;
    @Column(name = "modifiedTime")
    protected LocalDateTime modifiedTime;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = nowTime();
        this.createdTime = now;
        this.modifiedTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedTime = nowTime();
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}