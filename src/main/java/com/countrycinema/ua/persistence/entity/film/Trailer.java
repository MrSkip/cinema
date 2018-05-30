package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "trailers")
@Data
@ToString(callSuper = true, exclude = {"film"})
@EqualsAndHashCode(callSuper = true, exclude = {"film"})
public class Trailer extends TimeComponentLong<Trailer> {

    @Column(name = "name")
    private String name;
    @Column(name = "link")
    private String link;
    @Column(name = "text", length = 1_000)
    private String text;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

}
