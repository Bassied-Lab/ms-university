package com.bassied.ms.university.dto;


import com.bassied.ms.university.enums.City;
import com.bassied.ms.university.enums.Country;

public record UniversityCardDTO(Long id, City city, Country country, String name, Integer facultyCount,
                                Integer minPrice) {
}
