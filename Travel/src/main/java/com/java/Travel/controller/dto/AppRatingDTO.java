package com.java.Travel.controller.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class AppRatingDTO {
    @NotNull
    private Number value;

    @NotNull
    private Number finalValue;

    @NotNull
    private BigInteger iDClientA;

    public AppRatingDTO() {}

    AppRatingDTO(Number value, Number finalValue, BigInteger iDClientA) {
        this.value = value;
        this.finalValue = finalValue;
        this.iDClientA = iDClientA;
    }
}

