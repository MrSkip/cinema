package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.common.enums.FilmRole;
import com.countrycinema.ua.common.enums.Gender;
import com.countrycinema.ua.dto.film.actor.ActorRequestDTO;
import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Could contain producers and actors
 */
@Entity
@Table(name = "actors")
@Data
@ToString(callSuper = true, exclude = {"films"})
@EqualsAndHashCode(callSuper = true, exclude = {"films"})
public class Actor extends TimeComponentLong<Actor> {

    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "role", columnDefinition = "varchar(200) default 'ACTOR'")
    private FilmRole role = FilmRole.ACTOR;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> films;

    public void fetch(ActorRequestDTO dto) {
        name = dto.getName();
        gender = dto.getGender();
        age = dto.getAge();
    }
}
