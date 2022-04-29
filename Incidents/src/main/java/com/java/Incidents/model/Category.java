package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class Category extends BaseEntity {
    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<Incidents> incidents;

    @NotNull
    @Column(name = "CategoryName_", length = 15)
    String CategoryName;
    @NotNull
    @Column(name = "Description_Category", length = 15)
    String DescriptionCategory;
}
