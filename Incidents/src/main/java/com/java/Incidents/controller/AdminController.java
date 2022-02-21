package com.java.Incidents.controller;

import com.java.Incidents.model.AdminEntity;
import com.java.Incidents.servicesImpl.AdminServiceInterfImpl;
import org.springframework.http.ResponseEntity;

public class AdminController extends AbstractController<AdminEntity, AdminServiceInterfImpl>{
    @Override
    public ResponseEntity<AdminEntity> save(AdminEntity entity) {
        return null;
    }
}
