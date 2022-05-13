package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.repository.DetachmentRepository;
import com.java.Travel.service.DetachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DetachmentServiceImpl implements DetachmentService {
    @Autowired
    private DetachmentRepository detachmentRepository;
    @Override
    public void save(DetachmentDTO detachmentDTO) {

    }

    /*@Override
    public List<DetachmentDTO> findAll() {
        List<DetachmentEntity> list = detachmentRepository.findAll();
        return list.stream()
                .map(c -> new DetachmentDTO(c.getId(), c.getDetachmentName()))
                .collect(Collectors.toList());
    }*/

    @Override
    public List<DetachmentDTO> findAll() {
//        List<CompanyEntity> companyEntities = companyRepository.findAllAndOrderByName();
        List<DetachmentEntity> detachmentEntities = detachmentRepository.findAll();
        return detachmentEntities.stream().map(a -> new DetachmentDTO(a.getId(), a.getDetachmentName())).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public DetachmentDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(DetachmentDTO detachmentDTO) {

    }
    @Override
    public List<DetachmentDTO> getDetachmentName () {
        List<DetachmentEntity> detachmentEntities = detachmentRepository.getDetachmentName();
        return detachmentEntities.stream()
                .map(c -> new DetachmentDTO(c.getId(), c.getDetachmentName()))
                .collect(Collectors.toList());
    }

}
