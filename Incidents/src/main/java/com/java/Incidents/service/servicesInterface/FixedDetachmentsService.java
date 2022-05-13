package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.FixedDetachmentsDTO;

public interface FixedDetachmentsService {
    boolean save(FixedDetachmentsDTO fixedDetachmentsDTO);

    void deleteUserById(Long id);

    FixedDetachmentsDTO findUserById(Long id);

    void update(DetachmentDTO detachmentDTO);
}
