package com.java.Travel.service;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.FixedDetachmentsDTO;
import com.java.Travel.controller.dto.IncidentDTO;

import java.util.List;

public interface FixedDetachmentsService {
    boolean save(FixedDetachmentsDTO fixedDetachmentsDTO);

    void deleteUserById(Long id);

    FixedDetachmentsDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);

    List<FixedDetachmentsDTO> getFixedDetachments();
}
