package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film_actor")
@Data
@ToString(callSuper = true, exclude = {"film", "actor", "filmProducer"})
@EqualsAndHashCode(callSuper = true, exclude = {"film", "actor", "filmProducer"})
public class FilmActor extends IdComponentLong<FilmActor> {

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    /**
     * To defined a producers for film
     */
    @ManyToOne
    @JoinColumn(name = "film_producer_id")
    private Film filmProducer;

}
