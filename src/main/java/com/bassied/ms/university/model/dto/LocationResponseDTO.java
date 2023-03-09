package com.bassied.ms.university.model.dto;

import com.bassied.ms.university.model.enums.City;
import com.bassied.ms.university.model.enums.Country;

public record LocationResponseDTO(Country country,
                                  City city,
                                  String address,
                                  Double longitude,
                                  Double latitude) {
}
