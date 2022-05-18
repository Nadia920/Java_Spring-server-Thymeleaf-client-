package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "fixed_detachments")
@Getter
@Setter
@NoArgsConstructor
public class FixedDetachmentsEntity extends BaseEntity {
   /* @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)*/
    @ManyToOne()
    @JoinColumn(name = "fixed_det_detachment_id")
    private DetachmentEntity detachmentEntity;
    /*@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)*/
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "fixed_detachments_company_id")
    private CompanyEntity companyEntity;

    public FixedDetachmentsEntity(DetachmentEntity detachmentEntity, CompanyEntity companyEntity ){
        this.detachmentEntity = detachmentEntity;
        this.companyEntity = companyEntity;
    }
}
