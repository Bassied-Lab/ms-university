package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "universities")
public class University extends BaseEntity {

    private String name;
    private Long foreignStudentCount;
    private Long facultyCount;
    private Integer minPrice;
    private String base64_logo;


    private String email;
    private String phoneNumber;
    private String fax;

    private String aboutUniversityAz;
    private String aboutUniversityRu;
    private String aboutUniversityEn;

    @OneToMany(mappedBy = "university")
    private Set<RequiredDoc> requiredDocs;

    @OneToMany(mappedBy = "university")
    private Set<ForeignStudent> foreignStudents;

    @OneToMany(mappedBy = "university")
    private List<Location> locations;


    //    @ManyToMany
//    @JoinTable(name = "faculties_universities",
//            joinColumns = {@JoinColumn(name = "university_id")},
//            inverseJoinColumns = {@JoinColumn(name = "faculty_id")})
    @ManyToMany(mappedBy = "universities")
    private Set<Faculty> faculties;

}
