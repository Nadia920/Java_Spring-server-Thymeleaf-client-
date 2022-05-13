package com.java.Travel.controller.dto;



import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;

public class FixedDetachmentsDTO {

    private Long id;

    private DetachmentEntity detachmentEntity;

    private CompanyEntity companyEntity;

    public FixedDetachmentsDTO() {}

    FixedDetachmentsDTO(DetachmentEntity detachment, CompanyEntity company) {
        this.detachmentEntity = detachment;
        this.companyEntity = company;
    }

    public FixedDetachmentsDTO(Long id, DetachmentEntity detachmentEntity, CompanyEntity companyEntity) {
        this.id = id;
        this.detachmentEntity = detachmentEntity;
        this.companyEntity = companyEntity;
    }
}

