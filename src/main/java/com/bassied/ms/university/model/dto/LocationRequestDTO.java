package com.bassied.ms.university.model.dto;

import com.bassied.ms.university.model.enums.City;
import com.bassied.ms.university.model.enums.Country;

public record LocationRequestDTO(Country country,
                                 City city,
                                 String addressAz,
                                 String addressRu,
                                 String addressEn,
                                 Double longitude,
                                 Double latitude,
                                 Long universityId) {
}
