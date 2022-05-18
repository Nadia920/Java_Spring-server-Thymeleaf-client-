package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.repository.DetachmentRepository;
import com.java.Travel.service.DetachmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DetachmentEntity> findAll() {
        return detachmentRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {

    }


    @Override
    public void update(DetachmentDTO detachmentDTO) {

    }

    @Override
    public List<DetachmentDTO> getDetachmentName() {
        List<DetachmentEntity> detachmentEntities = detachmentRepository.getDetachmentName();
        return detachmentEntities.stream()
                .map(c -> new DetachmentDTO(c.getId(), c.getDetachmentName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean save(DetachmentEntity obj) {
        DetachmentEntity a = detachmentRepository.save(obj);
        if (a == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<DetachmentEntity> all() {
        return detachmentRepository.findAll();
    }

    public DetachmentServiceImpl(DetachmentRepository detachmentRepository) {
        this.detachmentRepository = detachmentRepository;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetachmentEntity findById(Long id) {
        return detachmentRepository.findById(id).get();
    }

   

}
