package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.TestDTO;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.repository.TestsRepository;
import com.java.Travel.service.QuestionService;
import com.java.Travel.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestsServiceImpl implements TestsService {

    @Autowired
    private TestsRepository testsRepository;
    @Override
    public boolean save(TestDTO testDTO) {
        return false;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public TestDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(TestDTO testDTO) {

    }
}
