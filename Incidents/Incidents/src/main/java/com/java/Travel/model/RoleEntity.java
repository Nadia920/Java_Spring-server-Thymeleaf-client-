package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_role")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity extends BaseEntity{

    @Column(name = "role", length = 12)
    String role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roleEntity")
    List<UserEntity> users;

    public RoleEntity(Long id, String role, List<UserEntity> users) {
        super(id);
        this.role = role;
        this.users = users;
    }

    public RoleEntity(String role, List<UserEntity> users) {
        this.role = role;
        this.users = users;
    }
}
