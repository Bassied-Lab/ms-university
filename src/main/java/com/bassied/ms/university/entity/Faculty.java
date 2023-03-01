package com.bassied.ms.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Faculty {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer code;
    private String logoPath;

    @ManyToMany
    private Set<University> universities;

    @OneToMany(mappedBy = "faculty")
    private List<Language> languageList;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
