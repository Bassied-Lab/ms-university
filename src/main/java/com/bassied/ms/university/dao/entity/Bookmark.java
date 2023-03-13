package com.bassied.ms.university.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "bookmarks")
public class Bookmark extends BaseEntity {

    private Long userId;

    @ManyToOne
    private University university;

    private boolean bookmarked;

}
