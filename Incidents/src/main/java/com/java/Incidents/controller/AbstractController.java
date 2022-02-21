package com.java.Incidents.controller;

import com.java.Incidents.model.AbstractEntity;
import com.java.Incidents.servicesInterface.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }


}
