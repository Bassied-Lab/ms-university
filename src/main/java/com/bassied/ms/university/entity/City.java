package com.bassied.ms.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class City extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<University> universityList;

}
