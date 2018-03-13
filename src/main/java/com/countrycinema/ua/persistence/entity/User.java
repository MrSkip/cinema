package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.persistence.entity.core.time.TimeComponentLong;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends TimeComponentLong<User> {

    @Column(name = "username")
    public String username;
    @Column(name = "password")
    public String password;

}
