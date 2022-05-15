package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @NotNull
    @Column(name = "last_name_user", length = 15)
    private String lastNameUser;

    @NotNull
    @Column(name = "first_name_user", length = 15)
    private String firstNameUser;

    @NotNull
    @Column(name = "patronymic_user", length = 15)
    private String patronymicUser;

    @Column(name = "email", length = 40)
    private String email;

    @NotNull
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @NotNull
    @Column(name = "login", length = 15)
    private String login;

    @NotNull
    @Column(name = "password", length = 15)
    private String password;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_role_id")
    private RoleEntity roleEntity;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_company_id")
    private CompanyEntity companyEntity;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<AppRating> appRating;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<ResultsEntity> resultsEntity;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private Set<IncidentsEntity> incidentsEntity;

    public UserEntity(UserEntity user) {
        this.setId(user.getId());
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.roleEntity = user.getRoleEntity();
        this.firstNameUser = user.getFirstNameUser();
        this.lastNameUser = user.getLastNameUser();
        this.patronymicUser = user.getPatronymicUser();
        this.phoneNumber = user.getPhoneNumber();

    }


    public UserEntity(@NotNull String login, String email, @NotNull String password, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, Set<IncidentsEntity> incidents, RoleEntity roleEntity, CompanyEntity companyEntity) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstNameUser = firstName;
        this.lastNameUser = lastName;
        this.patronymicUser = patronymic;
        this.phoneNumber = phoneNumber;
        this.incidentsEntity = incidents;
        this.roleEntity = roleEntity;
        this.companyEntity = companyEntity;
    }

    public UserEntity(@NotNull String login, String email, @NotNull String password, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, Set<IncidentsEntity> incidents, Set<AppRating> appRating, RoleEntity roleEntity, CompanyEntity companyEntity) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstNameUser = firstName;
        this.lastNameUser = lastName;
        this.patronymicUser = patronymic;
        this.phoneNumber = phoneNumber;
        this.incidentsEntity = incidents;
        this.appRating = appRating;
        this.roleEntity = roleEntity;
        this.companyEntity = companyEntity;
    }

    public UserEntity(@NotNull String login, String email, @NotNull String password, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, Set<IncidentsEntity> incidents, Set<AppRating> appRating, Set<ResultsEntity> results, RoleEntity roleEntity, CompanyEntity companyEntity) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstNameUser = firstName;
        this.lastNameUser = lastName;
        this.patronymicUser = patronymic;
        this.phoneNumber = phoneNumber;
        this.incidentsEntity = incidents;
        this.appRating = appRating;
        this.resultsEntity = results;
        this.roleEntity = roleEntity;
        this.companyEntity = companyEntity;
    }

    public UserEntity(String string, String string0, String string1, String string2) {
        this.login = string;
        this.email = string0;
        this.password = string1;
        this.firstNameUser = string2;
    }

   



}