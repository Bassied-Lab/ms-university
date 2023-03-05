package com.bassied.ms.university.entity;

import com.bassied.ms.university.enums.City;
import com.bassied.ms.university.enums.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private City city;
    private String addressAz;
    private String addressRu;
    private String addressEn;
    private Double longitude;
    private Double latitude;

    @ManyToOne
    University university;

}
