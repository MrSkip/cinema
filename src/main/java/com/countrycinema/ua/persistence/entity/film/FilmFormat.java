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
@Table(name = "formats")
@Data
@ToString(callSuper = true, exclude = {"film", "format"})
@EqualsAndHashCode(callSuper = true, exclude = {"film", "format"})
public class FilmFormat extends IdComponentLong<FilmFormat> {

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "format_id")
    private Format format;

}
