package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.ProblemDTO;
import com.java.Travel.repository.ProblemsRepository;
import com.java.Travel.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemsRepository problemRepository;
    @Override
    public void save(ProblemDTO problemDTO) {

    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public ProblemDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(ProblemDTO problemDTO) {

    }
}
