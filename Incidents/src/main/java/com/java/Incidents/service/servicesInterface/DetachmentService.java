package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.CategoryDTO;
import com.java.Incidents.controller.dto.DetachmentDTO;

public interface DetachmentService {
    boolean save(DetachmentDTO detachmentDTO);

    void deleteUserById(Long id);

    DetachmentDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);
}
