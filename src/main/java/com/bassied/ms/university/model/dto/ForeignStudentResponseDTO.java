package com.bassied.ms.university.model.dto;

import com.bassied.ms.university.model.enums.Country;

public record ForeignStudentResponseDTO(Country country,
                                        Integer count) {
}
