package com.bassied.ms.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
