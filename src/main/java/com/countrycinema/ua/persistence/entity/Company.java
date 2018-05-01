package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity.core.time.TimeComponentString;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "companies")
public class Company extends TimeComponentString<Company> {

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "timeZone")
    private String timeZone;

}
