package com.java.Travel.controller.dto;



import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixedDetachmentsDTO {

    private Long id;

    private DetachmentEntity detachmentName;

    private CompanyEntity companyName;

    public FixedDetachmentsDTO() {}

    FixedDetachmentsDTO(DetachmentEntity detachment, CompanyEntity company) {
        this.detachmentName = detachment;
        this.companyName = company;
    }

    public FixedDetachmentsDTO(Long id, DetachmentEntity detachmentName, CompanyEntity companyName) {
        this.id = id;
        this.detachmentName = detachmentName;
        this.companyName = companyName;
    }
}

