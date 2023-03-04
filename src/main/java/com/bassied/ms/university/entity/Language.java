package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "languages")
public class Language extends BaseEntity{

    private String name;

    @ManyToOne
    private Faculty faculty;

}
