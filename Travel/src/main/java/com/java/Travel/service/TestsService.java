package com.java.Travel.service;

import com.java.Travel.controller.dto.TestDTO;

public interface TestsService {
    boolean save(TestDTO testDTO);

    void deleteUserById(Long id);

    TestDTO findUserById(Long id);

    void update(TestDTO testDTO);
}
