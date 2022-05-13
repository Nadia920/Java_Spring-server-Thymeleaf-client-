package com.java.Travel.service;

import com.java.Travel.controller.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    boolean save(QuestionDTO questionDTO);

    void deleteUserById(Long id);

    QuestionDTO findUserById(Long id);

    void update(QuestionDTO questionDTO);

    void save(List<QuestionDTO> questionDTOList, String role_client);
}
