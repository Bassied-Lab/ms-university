package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Student extends BaseEntity {

    private String name;

}
