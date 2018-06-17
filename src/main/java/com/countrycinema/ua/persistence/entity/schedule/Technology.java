package com.countrycinema.ua.persistence.entity.schedule;

import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@Data
@ToString(callSuper = true, exclude = {"company"})
@EqualsAndHashCode(callSuper = true, exclude = {"company"})
public class Technology extends TimeComponentLong<Technology> {

    @Column(name = "name")
    private String name;
    @Column(name = "text", columnDefinition = "longtext")
    private String text;
    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
