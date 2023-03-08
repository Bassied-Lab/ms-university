package com.bassied.ms.university.model.dto;


public record UniversityCardDTO(Long id,
                                String city,
                                String country,
                                String name,
                                String logo,
                                Long facultyCount,
                                Long foreignStudentCount,
                                Integer minPrice) {
}
