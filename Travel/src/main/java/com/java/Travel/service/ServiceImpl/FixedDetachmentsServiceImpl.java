package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.FixedDetachmentsDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.model.FixedDetachmentsEntity;
import com.java.Travel.repository.FixedDetachmentsRepository;
import com.java.Travel.service.FixedDetachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FixedDetachmentsServiceImpl implements FixedDetachmentsService {
    @Autowired
    private FixedDetachmentsRepository fixedDetachmentsRepository;
    @Override
    public boolean save(FixedDetachmentsDTO fixedDetachmentsDTO) {
        return false;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public FixedDetachmentsDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(DetachmentDTO detachmentDTO) {

    }

    public List<FixedDetachmentsDTO> getFixedDetachments() {
        List<FixedDetachmentsEntity> fixedDetachmentsEntity = fixedDetachmentsRepository.getFixedDetachmens();
        return fixedDetachmentsEntity.stream()
                .map(c -> new FixedDetachmentsDTO(c.getId(), c.getDetachmentEntity(), c.getCompanyEntity()))
                .collect(Collectors.toList());
    }
}
