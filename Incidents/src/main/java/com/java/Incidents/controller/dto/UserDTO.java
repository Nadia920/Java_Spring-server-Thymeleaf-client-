package com.java.Incidents.controller.dto;

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

    private String role;

    public UserDTO() {}

    public UserDTO(@NotNull String login, @NotNull String password, @NotNull String email, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, String role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public UserDTO(Long id, @NotNull String login, @NotNull String password, @NotNull String email, @NotNull String firstName, @NotNull String lastName, @NotNull String patronymic, @NotNull String phoneNumber, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public UserDTO(String login, String password, String email, String firstName, String lastName, String patronymic, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }

    public UserDTO(Long id) {}


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
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}

