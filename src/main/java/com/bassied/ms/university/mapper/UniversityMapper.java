package com.bassied.ms.university.mapper;

import com.bassied.ms.university.dao.entity.Faculty;
import com.bassied.ms.university.dao.entity.Location;
import com.bassied.ms.university.dao.entity.University;
import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;
import com.bassied.ms.university.util.Base64Util;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UniversityMapper {

    @Mapping(target = "base64_logo", source = "logo")
    University toUniversity(UniversityRequestDTO universityRequestDTO);

    @Mapping(target = "base64_icon", source = "icon")
    Faculty toFaculty(FacultyRequestDTO facultyRequestDTO);


    @Mapping(target = "city", expression = "java(university.getLocation().getCity().toString())")
    @Mapping(target = "country", expression = "java(university.getLocation().getCountry().toString())")
    @Mapping(target = "logo", expression = "java(new String(decoder.decode(university.getBase64_logo())))")
    UniversityCardDTO toUniversityCardDTO(University university, @Context Base64Util decoder);

    @Mapping(target = "university.id", source = "universityId")
    Location toLocation(LocationRequestDTO locationRequestDTO);

}
