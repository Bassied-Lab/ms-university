package com.bassied.ms.university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookmarks")
public class Bookmark extends BaseEntity {

    private Long userId;

    private Long universityId;

    private boolean bookmarker;

}
