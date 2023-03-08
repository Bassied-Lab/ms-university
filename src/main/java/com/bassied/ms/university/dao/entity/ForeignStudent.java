package com.bassied.ms.university.dao.entity;

import com.bassied.ms.university.model.enums.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "foreign_students")
public class ForeignStudent extends BaseEntity {

    private Country country;
    private Integer count;

    @ManyToOne(optional = false)
    private University university;

}
