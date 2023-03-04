package com.bassied.ms.university.mapper;

import com.bassied.ms.university.dto.UniversityCardDto;
import com.bassied.ms.university.entity.University;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UniversityMapper {

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.country.name", target = "countryName")
    @Mapping(target = "numberOfFaculty", expression = "java(university.getFaculties().size())")
    UniversityCardDto toUniversityCardDto(University university);

}
