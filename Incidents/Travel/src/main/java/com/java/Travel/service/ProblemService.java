package com.java.Travel.service;

import com.java.Travel.controller.dto.FixedDetachmentsDTO;
import com.java.Travel.controller.dto.ProblemDTO;
import com.java.Travel.model.ProblemsEntity;
import org.springframework.transaction.annotation.Transactional;

public interface ProblemService {

    void deleteUserById(Long id);

    ProblemDTO findUserById(Long id);

    void update(ProblemDTO problemDTO);


    void save(ProblemsEntity problem);
}