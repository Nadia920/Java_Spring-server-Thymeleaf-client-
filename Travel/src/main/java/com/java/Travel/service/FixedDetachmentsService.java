package com.java.Travel.service;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.controller.dto.FixedDetachmentsDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FixedDetachmentsService {

    void deleteUserById(Long id);

    FixedDetachmentsDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);

    List<FixedDetachmentsDTO> getFixedDetachments();

    @Transactional
    void save(FixedDetachmentsDTO fixedDetachmentsDTO);
}
