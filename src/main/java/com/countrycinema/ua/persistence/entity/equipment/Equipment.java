package com.countrycinema.ua.persistence.entity.equipment;

import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity.Hall;
import com.countrycinema.ua.persistence.entity._core.id.IdComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment")
@Data
@ToString(callSuper = true, exclude = {"company", "halls"})
@EqualsAndHashCode(callSuper = true, exclude = {"company", "halls"})
public class Equipment extends IdComponentLong<Equipment> {

    private String projectorName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "equipment")
    private List<Hall> halls;
}
