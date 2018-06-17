package com.countrycinema.ua.persistence.entity._core.time;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TimeComponentLong<T extends TimeComponentLong> extends IdComponentLong<T> implements TimeComponent {

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
