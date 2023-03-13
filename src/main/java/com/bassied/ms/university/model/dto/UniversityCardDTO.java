package com.bassied.ms.university.model.dto;


import com.bassied.ms.university.model.enums.City;
import com.bassied.ms.university.model.enums.Country;

public record UniversityCardDTO(Long id,
                                City city,
                                Country country,
                                String name,
                                String logo,
                                Long facultyCount,
                                Long foreignStudentCount,
                                Integer minPrice) {
}
