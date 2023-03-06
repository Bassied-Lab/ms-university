package com.bassied.ms.university.dto;


import com.bassied.ms.university.enums.City;
import com.bassied.ms.university.enums.Country;

public record UniversityCardDTO(Long id, City city, Country country, String name, String logo,
                                Integer facultyCount, Integer minPrice) {
}
