package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity._core.time.TimeComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tokens")
@Data
@ToString(callSuper = true, exclude = "user")
@EqualsAndHashCode(callSuper = true, exclude = "user")
public class Token extends TimeComponentLong<Token> {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "token")
    private String token;

    public Token() {
    }

    public Token(String token) {
        this.token = token;
    }

}
