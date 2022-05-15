package com.java.Travel.service;

import com.java.Travel.controller.dto.ProblemDTO;
import com.java.Travel.controller.dto.QuestionDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionService {

    @Transactional
    void save(QuestionDTO questionDTO);


    /*QuestionService(QuestionDTO questionDTO);*/

    void deleteUserById(Long id);

    QuestionDTO findUserById(Long id);

    void update(QuestionDTO questionDTO);

    void save(List<QuestionDTO> questionDTOList, String role_client);
}
