package com.bassied.ms.university.entity;

import com.bassied.ms.university.MediaType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "path")
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseEntity{
    private String name;
    private String description;
    private String path;
    private String extension;
    @Enumerated(EnumType.STRING)
    private MediaType mimeType;
    private Long size;

    @ManyToOne
    private University university;

}
