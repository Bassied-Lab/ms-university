package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne
    private Faculty faculty;

}
