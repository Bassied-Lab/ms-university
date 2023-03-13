package com.bassied.ms.university.mapper;

import com.bassied.ms.university.dao.entity.Faculty;
import com.bassied.ms.university.dao.entity.ForeignStudent;
import com.bassied.ms.university.dao.entity.Location;
import com.bassied.ms.university.dao.entity.RequiredDoc;
import com.bassied.ms.university.dao.entity.University;
import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.FacultyResponseDTO;
import com.bassied.ms.university.model.dto.ForeignStudentResponseDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.LocationResponseDTO;
import com.bassied.ms.university.model.dto.RequiredDocResponseDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;
import com.bassied.ms.university.model.dto.UniversityResponseDTO;
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


    @Mapping(target = "city", expression = "java(university.getLocation().getCity())")
    @Mapping(target = "country", expression = "java(university.getLocation().getCountry())")
    @Mapping(target = "logo", expression = "java(new String(decoder.decode(university.getBase64_logo())))")
    UniversityCardDTO toUniversityCardDTO(University university, @Context Base64Util decoder);

    @Mapping(target = "university.id", source = "universityId")
    Location toLocation(LocationRequestDTO locationRequestDTO);

    @Mapping(target = "aboutUniversity", source = "aboutUniversityAz")
    @Mapping(target = "logo", expression = "java(new String(decoder.decode(university.getBase64_logo())))")
    UniversityResponseDTO toUniversityResponseDTOAz(University university, @Context Base64Util decoder);

    @Mapping(target = "aboutUniversity", source = "aboutUniversityRu")
    @Mapping(target = "logo", expression = "java(new String(decoder.decode(university.getBase64_logo())))")
    UniversityResponseDTO toUniversityResponseDTORu(University university, @Context Base64Util decoder);

    @Mapping(target = "aboutUniversity", source = "aboutUniversityEn")
    @Mapping(target = "logo", expression = "java(new String(decoder.decode(university.getBase64_logo())))")
    UniversityResponseDTO toUniversityResponseDTOEn(University university, @Context Base64Util decoder);

    RequiredDocResponseDTO toRequiredDocResponseDTO(RequiredDoc requiredDoc);

    @Mapping(target = "name", source = "nameAz")
    @Mapping(target = "icon", expression = "java(new String(decoder.decode(faculty.getBase64_icon())))")
    FacultyResponseDTO toFacultyResponseDTOAz(Faculty faculty, @Context Base64Util decoder);

    @Mapping(target = "name", source = "nameRu")
    @Mapping(target = "icon", expression = "java(new String(decoder.decode(faculty.getBase64_icon())))")
    FacultyResponseDTO toFacultyResponseDTORu(Faculty faculty, @Context Base64Util decoder);

    @Mapping(target = "name", source = "nameEn")
    @Mapping(target = "icon", expression = "java(new String(decoder.decode(faculty.getBase64_icon())))")
    FacultyResponseDTO toFacultyResponseDTOEn(Faculty faculty, @Context Base64Util decoder);

    @Mapping(target = "address", source = "addressAz")
    LocationResponseDTO toLocationResponseDTOAz(Location location);

    @Mapping(target = "address", source = "addressRu")
    LocationResponseDTO toLocationResponseDTORu(Location location);

    @Mapping(target = "address", source = "addressEn")
    LocationResponseDTO toLocationResponseDTOEn(Location location);

    ForeignStudentResponseDTO toForeignStudentResponseDTO(ForeignStudent foreignStudent);

}
