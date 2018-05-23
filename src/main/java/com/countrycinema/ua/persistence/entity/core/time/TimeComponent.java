package com.countrycinema.ua.persistence.entity.core.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public interface TimeComponent {

    default LocalDateTime nowTime() {
        return LocalDateTime.now();
    }

    LocalDateTime getCreatedTime();

    LocalDateTime getModifiedTime();

}
