package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.ProblemDTO;
import com.java.Incidents.controller.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    boolean save(QuestionDTO questionDTO);

    void deleteUserById(Long id);

    QuestionDTO findUserById(Long id);

    void update(QuestionDTO questionDTO);

    void save(List<QuestionDTO> questionDTOList, String role_client);
}
