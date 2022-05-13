package com.java.Incidents.service;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionServiceInterfImpl {
    @Autowired
    private QuestionsRepository questionRepository;


    /*@Transactional
    @Override
    public boolean save(QuestionDTO questionDTO) {

        Long idExistUser = questionRepository.getIdQuestionByNameFixedDetachment(questionDTO.getNameDetachment());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist",  problemDTO);
        }

        Question question = new Question();
        question.setNameDetachment(questionDTO.getNameDetachment());
        question.setSpecialization(questionDTO.getSpecialization());

        questionRepository.save(question);

        return true;
    }

    @Override
    public List<QuestionDTO> getProblemById(Long id) {

        List<Question> fixedDetachmentsList = questionRepository.findAllByQuestionName(Long name);
        List<QuestionDTO> questionDTOList = fixedDetachmentsList.stream()
                .map(a -> new DetachmentDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return questionDTOList;

    }

    @Transactional
    @Override
    public void deleteProblemById(Long id) throws UserNotFoundException {
        Optional<Question> questionEntity = questionRepository.findById(id);

        if (questionEntity.isPresent()) {
            questionRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Problem with id=" + id + " not found");
        }
    }

    @Override
    public QuestionDTO findProblemById(Long id) {
        Optional<Question> questionEntity = questionRepository.findById(id);
        return questionEntity.isPresent() ? mapProblemDTO(questionEntity.get()) : null;
    }

    private QuestionDTO mapQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setNameDetachment(question.getNameDetachment());
        questionDTO.setSpecialization(question.getSpecialization());
        return questionDTO;
    }

    @Transactional
    @Override
    public void update(QuestionDTO question) {

        Long idExistFixedDetachments = problemRepository.getIdDetachmentByCategoryName(question.getNameDetachment());

        if (idExistFixedDetachments != null && !idExistQuestion.equals(question.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", question);
        }


        Optional<Question> editQuestionEntity = questionRepository.findById(question.getId());
        if (editQuestionEntity.isPresent()) {

            editQuestionEntity.get().setNameDetachment(question.getNameDetachment());
            editQuestionEntity.get().setSpecialization(question.getSpecialization());

            questionRepository.save(editQuestionEntity.get());
        } else {
            throw new UserNotFoundException("Detachment with id=" +  questionDetachments.getId() + " not found");
        }

    }*/
}
