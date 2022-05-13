package com.java.Travel.service;

import com.java.Travel.controller.dto.CountryDTO;
import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.model.DetachmentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DetachmentService {

    void deleteUserById(Long id);

    DetachmentDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);

    List<DetachmentDTO> getDetachmentName();

    @Transactional
    void save(DetachmentDTO detachmentDTO);

    List<DetachmentDTO> findAll();

    boolean save(DetachmentEntity obj);
}
