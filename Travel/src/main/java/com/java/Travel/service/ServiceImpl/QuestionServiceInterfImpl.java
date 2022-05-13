package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.QuestionDTO;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.repository.QuestionsRepository;
import com.java.Travel.service.ProblemService;
import com.java.Travel.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceInterfImpl implements QuestionService {

    @Autowired
    private QuestionsRepository questionsRepository;
    @Override
    public boolean save(QuestionDTO questionDTO) {
        return false;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public QuestionDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(QuestionDTO questionDTO) {

    }

    @Override
    public void save(List<QuestionDTO> questionDTOList, String role_client) {

    }
}
