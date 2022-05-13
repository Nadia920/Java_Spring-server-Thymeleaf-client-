package com.java.Travel.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
@Table(name = "app_rating")
@NoArgsConstructor
public class AppRating extends BaseEntity {

    @NotNull
    @Column(name = "value", length = 15)
    private Number Value;
    @NotNull
    @Column(name = "final_value", length = 15)
    private Number FinalValue;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "rating_users_id")
    private UserEntity userEntity;


    public static AppRating values(){
        AppRating app = new AppRating();
        return app;
    }
}
