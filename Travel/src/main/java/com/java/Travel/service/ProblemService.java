package com.java.Travel.service;

import com.java.Travel.controller.dto.ProblemDTO;

public interface ProblemService {
    boolean save(ProblemDTO problemDTO);

    void deleteUserById(Long id);

    ProblemDTO findUserById(Long id);

    void update(ProblemDTO problemDTO);
}
