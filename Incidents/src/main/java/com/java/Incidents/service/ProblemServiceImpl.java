package com.java.Incidents.service;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.FixedDetachmentsDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.Detachment;
import com.java.Incidents.model.FixedDetachments;
import com.java.Incidents.repository.FixedDetachmentsRepository;
import com.java.Incidents.repository.ProblemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProblemServiceImpl {
    @Autowired
    private ProblemsRepository problemRepository;


   /* @Transactional
    @Override
    public boolean save(ProblemDTO problemDTO) {

        Long idExistUser = problemRepository.getIdProblemByNameFixedDetachment(problemDTO.getNameDetachment());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist",  problemDTO);
        }

        Problem problem = new Problem();
        detachment.setNameDetachment(fixedDetachmentsDTO.getNameDetachment());
        detachment.setSpecialization(fixedDetachmentsDTO.getSpecialization());

        problemRepository.save(problem);

        return true;
    }

    @Override
    public List<ProblemDTO> getProblemById(Long id) {

        List<Problem> fixedDetachmentsList = problemRepository.findAllByProblemName(Long name);
        List<ProblemDTO> fixedDetachmentsDTOList = fixedDetachmentsList.stream()
                .map(a -> new DetachmentDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return problemDTOList;

    }

    @Transactional
    @Override
    public void deleteProblemById(Long id) throws UserNotFoundException {
        Optional<Problem> problemEntity = problemRepository.findById(id);

        if (problemEntity.isPresent()) {
            problemRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Problem with id=" + id + " not found");
        }
    }

    @Override
    public ProblemDTO findProblemById(Long id) {
        Optional<Problem> fixedDetachmentsEntity = problemRepository.findById(id);
        return fixedDetachmentsEntity.isPresent() ? mapProblemDTO(problemEntity.get()) : null;
    }

    private ProblemDTO mapProblemDTO(Problem problem) {
        ProblemDTO problemDTO = new ProblemDTO();
        problemDTO.setId(problem.getId());
        problemDTO.setNameDetachment(problem.getNameDetachment());
        problemDTO.setSpecialization(problem.getSpecialization());
        return problemDTO;
    }

    @Transactional
    @Override
    public void update(ProblemDTO problem) {

        Long idExistFixedDetachments = problemRepository.getIdDetachmentByCategoryName(problem.getNameDetachment());

        if (idExistFixedDetachments != null && !idExistDetachment.equals(problem.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", problem);
        }


        Optional<Problem> editProblemEntity = problemRepository.findById(problem.getId());
        if (editProblemEntity.isPresent()) {

            ediProblemEntity.get().setNameDetachment(problem.getNameDetachment());
            editProblemEntity.get().setSpecialization(problem.getSpecialization());

            problemRepository.save(editProblemEntity.get());
        } else {
            throw new UserNotFoundException("Detachment with id=" + problemDetachments.getId() + " not found");
        }

    }*/
}
