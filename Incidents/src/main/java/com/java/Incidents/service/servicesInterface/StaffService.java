package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.QuestionDTO;
import com.java.Incidents.controller.dto.StaffDTO;

public interface StaffService {
    boolean save(StaffDTO staffDTO);

    void deleteUserById(Long id);

    StaffDTO findUserById(Long id);

    void update(StaffDTO staffDTO);
}
