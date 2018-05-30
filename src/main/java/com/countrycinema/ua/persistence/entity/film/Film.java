package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "films")
@Data
@ToString(callSuper = true, exclude = {"company", "posters"})
@EqualsAndHashCode(callSuper = true, exclude = {"company", "posters"})
public class Film extends TimeComponentLong<Film> {

    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "country")
    private String country;
    @Column(name = "releasedAt")
    private LocalDate releasedAt;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "ageFrom", nullable = false, columnDefinition = "integer default 0")
    private int ageFrom;
    @Column(name = "genre", length = 1_000)
    private String genre;
    @Column(name = "text", columnDefinition = "longtext")
    private String text;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> actors;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trailer> trailers;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmPoster> posters;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
