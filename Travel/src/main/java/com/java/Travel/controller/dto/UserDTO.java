package com.java.Travel.controller.dto;

import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 14)
    private String login;

    @NotNull
    @Size(min = 8, max = 14)
    private String password;

    @NotNull
    @Email()
    private String email;

    @NotNull
    @Size(min = 3, max = 14)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 14)
    private String lastName;

    @NotNull
    @Size(min = 3, max = 14)
    private String patronymic;

    @NotNull
    @Pattern(regexp = "^375[(](17|25|29|33|44)[)]([0-9]{7})$")
    private String phoneNumber;

    private CompanyEntity companyEntity;

    private RoleEntity roleEntity;

    public UserDTO() {
    }

    public UserDTO(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserDTO(@NotNull String login, @NotNull String password, @NotNull String email, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, CompanyEntity companyEntity, RoleEntity roleEntity) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.companyEntity = companyEntity;
        this.roleEntity = roleEntity;
    }

    public UserDTO(Long id, @NotNull String login, @NotNull String password, @NotNull String email, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, CompanyEntity companyEntity, RoleEntity roleEntity) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.companyEntity = companyEntity;
        this.roleEntity = roleEntity;
    }

    public UserDTO(String login, String password, String email, String firstName, String lastName, String patronymic, String phoneNumber, CompanyEntity companyEntity) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.companyEntity = companyEntity;
    }

    public UserDTO(Long id) {
    }

    public UserDTO(Long id, String login, String password, String email, String firstNameUser, String lastNameUser, String patronymicUser, String phoneNumber, RoleEntity roleEntity) {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append(", id='").append(id).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", company='").append(companyEntity).append('\'');
        sb.append(", role=").append(roleEntity);
        sb.append('}');
        return sb.toString();
    }
}
