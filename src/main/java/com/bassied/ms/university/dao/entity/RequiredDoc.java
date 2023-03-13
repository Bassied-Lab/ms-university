package com.bassied.ms.university.dao.entity;

import com.bassied.ms.university.model.enums.Title;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "required_documents")
public class RequiredDoc extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Title title;

    @ManyToOne
    private University university;

}
