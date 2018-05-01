package com.countrycinema.ua.persistence.repository._core;

import com.countrycinema.ua.persistence.entity.core.id.IdComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OptionalRepository<E extends IdComponent, ID> extends JpaRepository<E, ID> {



}
