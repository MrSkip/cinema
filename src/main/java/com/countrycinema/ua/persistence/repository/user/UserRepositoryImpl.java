package com.countrycinema.ua.persistence.repository.user;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UserRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    public void customThing() {
        System.out.println("Test");
    }

}
