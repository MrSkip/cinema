//package com.countrycinema.ua.persistence.entity.schedule;
//
//import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
//import com.countrycinema.ua.persistence.entity.film.Film;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "trailers")
//@Data
//@ToString(callSuper = true, exclude = {"film", "technology"})
//@EqualsAndHashCode(callSuper = true, exclude = {"film", "technology"})
//public class FilmTechnology extends IdComponentLong<FilmTechnology> {
//
//    @ManyToOne
//    @JoinColumn(name = "film_id")
//    private Film film;
//    @ManyToOne
//    @JoinColumn(name = "technology")
//    private Technology technology;
//
//}
