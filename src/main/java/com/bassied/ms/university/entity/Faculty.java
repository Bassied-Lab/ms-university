package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Faculty extends BaseEntity{
    private String name;
    private Integer code;
    private String logoPath;

    @ManyToMany
    private Set<University> universities;

    @OneToMany(mappedBy = "faculty")
    private List<Language> languageList;

}
