package com.countrycinema.ua.persistence.entity._core.time;

import java.time.LocalDateTime;

public interface TimeComponent {

    default LocalDateTime nowTime() {
        return LocalDateTime.now();
    }

    LocalDateTime getCreatedTime();

    LocalDateTime getModifiedTime();

}
