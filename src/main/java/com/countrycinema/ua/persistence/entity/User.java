package com.countrycinema.ua.persistence.entity;

import com.countrycinema.ua.common.enums.UserRole;
import com.countrycinema.ua.persistence.entity.core.time.TimeComponentString;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
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
    private boolean gender;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(name = "activated", columnDefinition = "default false")
    private boolean activated = false;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Token token;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
