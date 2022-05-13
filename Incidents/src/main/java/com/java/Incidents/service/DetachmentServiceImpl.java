package com.java.Incidents.service;

import com.java.Incidents.controller.dto.CategoryDTO;
import com.java.Incidents.controller.dto.DetachmentDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.Category;
import com.java.Incidents.model.Detachment;
import com.java.Incidents.repository.CategoryRepository;
import com.java.Incidents.repository.DetachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DetachmentServiceImpl {
    @Autowired
    private DetachmentRepository detachmentRepository;


   /* @Transactional
    @Override
    public boolean save(DetachmentDTO detachmentDTO) {

        Long idExistUser = detachmentRepository.getIdDetachmentByNameDetachment(detachmentDTO.getNameDetachment());
        if (idExistUser != null) {
        throw new EditUsersParametersExistException("User_with_this_email_already_exist",  detachmentDTO);
    }

        Detachment detachment = new Detachment();
        detachment.setNameDetachment(detachmentDTO.getNameDetachment());
        detachment.setSpecialization(detachmentDTO.getSpecialization());

        detachmentRepository.save(detachment);

        return true;
}

    @Override
    public List<DetachmentDTO> getDetachmentById(Long id) {

        List<Detachment> detachmentList = detachmentRepository.findAllByDetachmentName(Long name);
        List<DetachmentDTO> detachmentDTOList = detachmentList.stream()
                .map(a -> new DetachmentDTO(
                        a.getId(),
                        a.getNameDetachment(),
                        a.getSpecialization()
                ))
                .collect(Collectors.toList());

        return detachmentDTOList;

    }

    @Transactional
    @Override
    public void deleteDetachmentById(Long id) throws UserNotFoundException {
        Optional<Detachment> detachmentEntity = detachmentRepository.findById(id);

        if (detachmentEntity.isPresent()) {
            detachmentRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Category with id=" + id + " not found");
        }
    }

    @Override
    public UserDTO findDetachmentById(Long id) {
        Optional<Detachment> detachmentEntity = detachmentRepository.findById(id);
        return detachmentEntity.isPresent() ? mapDetachmentDTO(detachmentEntity.get()) : null;
    }

    private DetachmentDTO mapDetachmentDTO(Detachment category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNameDetachment(category.getNameDetachment());
        categoryDTO.setSpecialization(category.getSpecialization());
        return categoryDTO;
    }

    @Transactional
    @Override
    public void update(DetachmentDTO detachment) {

        Long idExistDetachment = detachmentRepository.getIdDetachmentByCategoryName(detachment.getNameDetachment());

        if (idExistDetachment != null && !idExistDetachment.equals(detachment.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", detachment);
        }


        Optional<Detachment> editDetachmentEntity = detachmentRepository.findById(detachment.getId());
        if (editDetachmentEntity.isPresent()) {

            editDetachmentEntity.get().setNameDetachment(detachment.getNameDetachment());
            editDetachmentEntity.get().setSpecialization(detachment.getSpecialization());

            detachmentRepository.save(editDetachmentEntity.get());
        } else {
            throw new UserNotFoundException("Detachment with id=" + detachment.getId() + " not found");
        }

    }*/
}
