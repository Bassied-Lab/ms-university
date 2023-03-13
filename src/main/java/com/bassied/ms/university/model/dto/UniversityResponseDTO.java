package com.bassied.ms.university.model.dto;

public record UniversityResponseDTO(String name,
                                    Integer minPrice,
                                    String logo,
                                    String email,
                                    String phoneNumber,
                                    String fax,
                                    String aboutUniversity) {
}
