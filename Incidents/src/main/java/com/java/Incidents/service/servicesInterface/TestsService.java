package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.StaffDTO;
import com.java.Incidents.controller.dto.TestDTO;

public interface TestsService {
    boolean save(TestDTO testDTO);

    void deleteUserById(Long id);

    TestDTO findUserById(Long id);

    void update(TestDTO testDTO);
}
