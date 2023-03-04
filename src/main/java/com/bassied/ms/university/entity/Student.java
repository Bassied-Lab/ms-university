package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    private String name;

}
