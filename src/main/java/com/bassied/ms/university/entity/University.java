package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "universities")
public class University extends BaseEntity {

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String fax;
    private Integer minPrice;
    private String logoPath;
    private Double longitude;
    private Double latitude;
    private String aboutUniversity;

    @OneToMany(mappedBy = "university")
    private Set<File> files;

    @OneToMany(mappedBy = "university")
    private Set<Document> documents;

    @ManyToMany
    @JoinTable(name = "faculties_universities",
            joinColumns = {@JoinColumn(name = "university_id")},
            inverseJoinColumns = {@JoinColumn(name = "faculty_id")})
    private Set<Faculty> faculties;

    @ManyToOne(optional = false)
    private City city;

}
