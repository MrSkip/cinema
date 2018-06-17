package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "film_posters")
@Data
@ToString(callSuper = true, exclude = {"film"})
@EqualsAndHashCode(callSuper = true, exclude = {"film"})
public class FilmPoster extends IdComponentLong<FilmPoster> {

    @Column(name = "name")
    private String name;
    @Column(name = "pathOnLocal")
    private String pathOnLocal;
    @Column(name = "pathOnRemote")
    private String pathOnRemote;
    @Column(name = "link")
    private String link;
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

}
