package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import com.countrycinema.ua.persistence.entity.equipment.Equipment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "halls")
@Data
@ToString(callSuper = true, exclude = {"equipment", "company"})
@EqualsAndHashCode(callSuper = true, exclude = {"equipment", "company"})
public class Hall extends IdComponentLong<Hall> {

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "places")
    private String places;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
