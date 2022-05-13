package com.java.Incidents.service;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.TestDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.Tests;
import com.java.Incidents.repository.StaffRepository;
import com.java.Incidents.repository.TestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestsServiceImpl {
    @Autowired
    private TestsRepository testsRepository;


    /*@Transactional
    @Override
    public boolean save(TestDTO testsDTO) {

        Long idExistUser = testsRepository.getIdStaffByNameFixedDetachment(testsDTO.getNameDetachment());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist",  staffDTO);
        }

        Tests tests = new Tests();
        tests.setNameDetachment(testsDTO.getNameDetachment());
        tests.setSpecialization(testsDTO.getSpecialization());

        testsRepository.save(tests);

        return true;
    }

    @Override
    public List<TestsDTO> getProblemById(Long id) {

        List<Tests> testsList = testsRepository.findAllByQuestionName(Long name);
        List<TestsDTO> testsDTOList = testsList.stream()
                .map(a -> new TestsDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return testsDTOList;

    }

    @Transactional
    @Override
    public void deleteProblemById(Long id) throws UserNotFoundException {
        Optional<Tests> testsEntity = testsRepository.findById(id);

        if (testsEntity.isPresent()) {
            testsRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Problem with id=" + id + " not found");
        }
    }

    @Override
    public TestsDTO findProblemById(Long id) {
        Optional<Tests> testsEntity = testsRepository.findById(id);
        return testsEntity.isPresent() ? mapStaffDTO(testsEntity.get()) : null;
    }

    private TestsDTO mapTestsDTO(Tests tests) {
        TestsDTO testsDTO = new TestsDTO();
        testsDTO.setId(staff.getId());
        testsDTO.setNameDetachment(tests.getNameDetachment());
        testsDTO.setSpecialization(tests.getSpecialization());
        return testsDTO;
    }

    @Transactional
    @Override
    public void update(TestsDTO tests) {

        Long idExistStaff = testsRepository.getIdDetachmentByCategoryName(tests.getNameDetachment());

        if (idExistStaff != null && !idExistStaff.equals(tests.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", tests);
        }


        Optional<Tests> editTestsEntity = testsRepository.findById(tests.getId());
        if (editQuestionEntity.isPresent()) {

            editTestsEntity.get().setNameDetachment(tests.getNameDetachment());
            editTestsEntity.get().setSpecialization(tests.getSpecialization());

            testsRepository.save(editTestsEntity.get());
        } else {
            throw new UserNotFoundException("Tests with id=" +  testsDetachments.getId() + " not found");
        }

    }*/
}
