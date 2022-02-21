package com.java.Incidents.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommonEntity<E extends AbstractEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

}
