package com.java.Incidents.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.lang.model.type.ErrorType;
import javax.persistence.Column;
import java.math.BigInteger;

public abstract class AbstractEntity implements CommonEntity<E> {
    @javax.persistence.Id
    @Column
    private BigInteger id;
}
