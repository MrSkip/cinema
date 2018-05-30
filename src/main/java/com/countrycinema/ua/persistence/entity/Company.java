package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity._core.time.TimeComponentString;
import com.countrycinema.ua.persistence.entity.equipment.Equipment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@ToString(callSuper = true, exclude = {"users"})
@EqualsAndHashCode(callSuper = true, exclude = {"users"})
public class Company extends TimeComponentString<Company> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "timeZone")
    private String timeZone;

    @OneToMany(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<User> users;
    @OneToMany(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Hall> halls;
    @OneToMany(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Equipment> equipment;

}
