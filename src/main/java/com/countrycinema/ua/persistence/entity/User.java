package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.common.enums.Gender;
import com.countrycinema.ua.common.enums.UserRole;
import com.countrycinema.ua.persistence.entity._core.time.TimeComponentString;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@ToString(callSuper = true, exclude = {"company", "token"})
@EqualsAndHashCode(callSuper = true, exclude = {"company", "token"})
public class User extends TimeComponentString<User> {

    @Column(name = "username", unique = true)
    public String username;
    @Column(name = "password", nullable = false)
    public String password;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_born")
    private LocalDate dateOfBorn;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "role", columnDefinition = "varchar(50) default 'USER'")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    @Column(name = "activated", columnDefinition = "boolean default false")
    private boolean activated = false;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Token token;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
