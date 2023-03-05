package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "faculties")
public class Faculty extends BaseEntity {

    private String nameAz;
    private String nameRu;
    private String nameEn;
    private String base64_icon;

    @ManyToMany
    private Set<University> universities;

}
