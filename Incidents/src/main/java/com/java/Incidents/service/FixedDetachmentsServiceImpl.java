package com.java.Incidents.service;

import com.java.Incidents.controller.dto.CategoryDTO;
import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.FixedDetachmentsDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.Detachment;
import com.java.Incidents.model.FixedDetachments;
import com.java.Incidents.repository.DetachmentRepository;
import com.java.Incidents.repository.FixedDetachmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FixedDetachmentsServiceImpl {
    @Autowired
    private FixedDetachmentsRepository fixedDetachmentsRepository;


   /* @Transactional
    @Override
    public boolean save(FixedDetachmentsDTO fixedDetachmentsDTO) {

        Long idExistUser = fixedDetachmentsRepository.getIdFixedDetachmentByNameFixedDetachment(fixedDetachmentsDTO.getNameDetachment());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist",  fixedDetachmentDTO);
        }

        Detachment detachment = new Detachment();
        detachment.setNameDetachment(fixedDetachmentsDTO.getNameDetachment());
        detachment.setSpecialization(fixedDetachmentsDTO.getSpecialization());

        fixedDetachmentsRepository.save(detachment);

        return true;
    }

    @Override
    public List<FixedDetachmentsDTO> getFixedDetachmentById(Long id) {

        List<FixedDetachments> fixedDetachmentsList = fixedDetachmentsRepository.findAllByDetachmentName(Long name);
        List<FixedDetachmentsDTO> fixedDetachmentsDTOList = fixedDetachmentsList.stream()
                .map(a -> new DetachmentDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return fixedDetachmentsDTOList;

    }

    @Transactional
    @Override
    public void deleteDetachmentById(Long id) throws UserNotFoundException {
        Optional<FixedDetachments> fixedDetachmentsEntity = detachmentRepository.findById(id);

        if (fixedDetachmentsEntity.isPresent()) {
            fixedDetachmentsRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("FixedDetachment with id=" + id + " not found");
        }
    }

    @Override
    public FixedDetachmentsDTO findDetachmentById(Long id) {
        Optional<FixedDetachments> fixedDetachmentsEntity = fixedDetachmentsRepository.findById(id);
        return fixedDetachmentsEntity.isPresent() ? mapDetachmentDTO(fixedDetachmentsEntity.get()) : null;
    }

    private DetachmentDTO mapDetachmentDTO(Detachment category) {
        FixedDetachmentsDTO fixedDetachmentsDTO = new FixedDetachmentDTO();
        fixedDetachmentsDTO.setId(category.getId());
        fixedDetachmentsDTO.setNameDetachment(category.getNameDetachment());
        fixedDetachmentsDTO.setSpecialization(category.getSpecialization());
        return fixedDetachmentsDTO;
    }

    @Transactional
    @Override
    public void update(FixedDetachmentsDTO fixedDetachments) {

        Long idExistFixedDetachments = fixedDetachmentsRepository.getIdDetachmentByCategoryName(fixedDetachments.getNameDetachment());

        if (idExistFixedDetachments != null && !idExistDetachment.equals(detachment.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", detachment);
        }


        Optional<FixedDetachments> editFixedDetachmentsEntity = fixedDetachmentsRepository.findById(fixedDetachments.getId());
        if (editFixedDetachmentsEntity.isPresent()) {

            editFixedDetachmentsEntity.get().setNameDetachment(fixedDetachments.getNameDetachment());
            editFixedDetachmentsEntity.get().setSpecialization(fixedDetachments.getSpecialization());

            fixedDetachmentsRepository.save(editFixedDetachmentsEntity.get());
        } else {
            throw new UserNotFoundException("Detachment with id=" + fixedDetachments.getId() + " not found");
        }

    }*/
}
