package com.bassied.ms.university.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Document extends BaseEntity {

    private String description;

    @ManyToOne
    private University university;

}
