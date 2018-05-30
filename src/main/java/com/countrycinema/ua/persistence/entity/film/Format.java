package com.countrycinema.ua.persistence.entity.film;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

// 3d, 2d
@Entity
@Table(name = "formats")
@Data
@ToString(callSuper = true, exclude = {"filmFormats"})
@EqualsAndHashCode(callSuper = true, exclude = {"filmFormats"})
public class Format extends IdComponentLong<Format> {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "text", columnDefinition = "longtext")
    private String text;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "format")
    private List<FilmFormat> filmFormats;


}
