package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.FixedDetachmentsDTO;
import com.java.Incidents.controller.dto.ProblemDTO;

public interface ProblemService {
    boolean save(ProblemDTO problemDTO);

    void deleteUserById(Long id);

    ProblemDTO findUserById(Long id);

    void update(ProblemDTO problemDTO);
}
