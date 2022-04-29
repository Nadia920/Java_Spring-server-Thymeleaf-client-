package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "App_role")
@Getter
@Setter
public class Role extends BaseEntity{

    @Column(name = "role", length = 12)
    String role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    List<UserEntity> users;

    public Role(String role, List<UserEntity> users) {
        this.role = role;
        this.users = users;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(){}




}

