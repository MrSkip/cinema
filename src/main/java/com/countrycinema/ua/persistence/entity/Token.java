package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity.core.id.IdComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name =
        "tokens")
public class Token extends IdComponentLong<Token> {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "token")
    private String token;

}
