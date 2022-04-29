package com.java.Incidents.controller;

import com.java.Incidents.model.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public interface CommonController<E extends BaseEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);

}
