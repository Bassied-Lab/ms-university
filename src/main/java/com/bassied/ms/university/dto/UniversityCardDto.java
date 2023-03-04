package com.bassied.ms.university.dto;

import lombok.Data;


@Data
public class UniversityCardDto {

    private Long id;

    private String cityName;

    private String countryName;

    private String name;

    private Integer numberOfFaculty;

    private Integer minPrice;

}
