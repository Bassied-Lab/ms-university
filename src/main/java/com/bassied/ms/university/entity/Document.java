package com.bassied.ms.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Document {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    @ManyToOne
    private University university;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
