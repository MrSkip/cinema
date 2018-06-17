package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.dto.film.FilmRequestDTO;
import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import com.countrycinema.ua.persistence.entity.schedule.FilmSchedule;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "films")
@Data
@ToString(callSuper = true, exclude = {"posters", "schedules", "formats"})
@EqualsAndHashCode(callSuper = true, exclude = {"posters", "schedules", "formats"})
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

    @OneToMany(mappedBy = "filmProducer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> producers;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmActor> actors;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trailer> trailers;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmPoster> posters;
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmFormat> formats;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmSchedule> schedules;

    public void fetch(FilmRequestDTO film) {
        this.year = film.getYear();
        this.name = film.getName();
        this.country = film.getCountry();
        this.releasedAt = film.getReleasedAt();
        this.duration = film.getDuration();
        this.ageFrom = film.getAgeFrom();
        this.genre = film.getGenre();
        this.text = film.getText();
    }

//    @ManyToOne
//    @JoinColumn(name = "company_id", nullable = false)
//    private Company company;
}
