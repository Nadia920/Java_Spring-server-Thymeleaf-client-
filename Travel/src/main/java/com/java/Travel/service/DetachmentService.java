package com.java.Travel.service;

import com.java.Travel.controller.dto.DetachmentDTO;

import java.util.List;

public interface DetachmentService {
    boolean save(DetachmentDTO detachmentDTO);

    void deleteUserById(Long id);

    DetachmentDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);

    List<DetachmentDTO> getDetachmentName();
}
