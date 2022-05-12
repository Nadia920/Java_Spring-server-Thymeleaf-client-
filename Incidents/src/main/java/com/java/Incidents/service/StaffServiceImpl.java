package com.java.Incidents.service;

import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StaffServiceImpl {
    @Autowired
    private StaffRepository staffRepository;


    /*@Transactional
    @Override
    public boolean save(StaffDTO staffDTO) {

        Long idExistUser = questionRepository.getIdStaffByNameFixedDetachment(staffDTO.getNameDetachment());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist",  staffDTO);
        }

        Staff staff = new Staff();
        staff.setNameDetachment(staffDTO.getNameDetachment());
        staff.setSpecialization(staffDTO.getSpecialization());

        staffRepository.save(staff);

        return true;
    }

    @Override
    public List<StaffDTO> getProblemById(Long id) {

        List<Staff> fixedDetachmentsList = staffRepository.findAllByQuestionName(Long name);
        List<StaffDTO> questionDTOList = fixedDetachmentsList.stream()
                .map(a -> new DetachmentDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return staffDTOList;

    }

    @Transactional
    @Override
    public void deleteProblemById(Long id) throws UserNotFoundException {
        Optional<Staff> staffEntity = staffRepository.findById(id);

        if (staffEntity.isPresent()) {
            staffRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Problem with id=" + id + " not found");
        }
    }

    @Override
    public StaffDTO findProblemById(Long id) {
        Optional<Staff> staffEntity = staffRepository.findById(id);
        return staffEntity.isPresent() ? mapStaffDTO(staffEntity.get()) : null;
    }

    private StaffDTO mapStaffDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(staff.getId());
        staffDTO.setNameDetachment(staff.getNameDetachment());
        staffDTO.setSpecialization(staff.getSpecialization());
        return staffDTO;
    }

    @Transactional
    @Override
    public void update(StaffDTO staff) {

        Long idExistStaff = staffRepository.getIdDetachmentByCategoryName(staff.getNameDetachment());

        if (idExistStaff != null && !idExistStaff.equals(staff.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", question);
        }


        Optional<Staff> editQuestionEntity = staffRepository.findById(staff.getId());
        if (editQuestionEntity.isPresent()) {

            editQuestionEntity.get().setNameDetachment(staff.getNameDetachment());
            editQuestionEntity.get().setSpecialization(staff.getSpecialization());

            staffRepository.save(editQuestionEntity.get());
        } else {
            throw new UserNotFoundException("Detachment with id=" +  staffDetachments.getId() + " not found");
        }

    }*/
}
