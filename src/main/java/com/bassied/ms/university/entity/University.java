package com.bassied.ms.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class University {
    @Id
    @GeneratedValue
    private Integer id;

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

    @ManyToMany(mappedBy = "universities")
    private Set<Faculty> faculties;

    @ManyToOne
    private City city;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
