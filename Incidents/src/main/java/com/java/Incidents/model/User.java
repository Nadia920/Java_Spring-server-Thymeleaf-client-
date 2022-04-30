package com.java.Incidents.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Set;


@Entity
@Table(name = "Users")
@Getter
@Setter
public class User extends BaseEntity {

    @NotNull
    @Column(name = "login", length = 15)
    private String login;

    @Column(name = "email", length = 40)
    private String email;

    @NotNull
    @Column(name = "password", length = 15)
    private String password;

    @NotNull
    @Column(name = "first_name", length = 15)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 15)
    private String lastName;

    @NotNull
    @Column(name = "patronymic", length = 15)
    private String patronymic;

    @NotNull
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;


    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    BigInteger IDReceivingCompanyC;

    public User() {
    }

    public User(User user) {
        this.setId(user.getId());
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.patronymic = user.getPatronymic();
        this.phoneNumber = user.getPhoneNumber();

    }


    public User(@NotNull String login, String email, @NotNull String password, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, Set<Order> orders, Role role) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }




}
