package com.bassied.ms.university.model.dto;

public record UniversityRequestDTO(String name,
                                   Long foreignStudentCount,
                                   Long facultyCount,
                                   Integer minPrice,
                                   String logo,
                                   String email,
                                   String phoneNumber,
                                   String fax,
                                   String aboutUniversityAz,
                                   String aboutUniversityRu,
                                   String aboutUniversityEn) {
}
