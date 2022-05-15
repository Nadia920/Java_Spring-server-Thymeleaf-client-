package com.java.Travel.service;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.model.DetachmentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DetachmentService {

    void deleteUserById(Long id);

    DetachmentEntity findById(Long id);

    void update(DetachmentDTO detachmentDTO);

    List<DetachmentDTO> getDetachmentName();

    @Transactional
    void save(DetachmentDTO detachmentDTO);

    List<DetachmentEntity> findAll();

    List<DetachmentEntity> all();

    boolean save(DetachmentEntity obj);
}
