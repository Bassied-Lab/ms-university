package com.bassied.ms.university.service;


import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.FacultyResponseDTO;
import com.bassied.ms.university.model.dto.ForeignStudentResponseDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.LocationResponseDTO;
import com.bassied.ms.university.model.dto.RequiredDocResponseDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;
import com.bassied.ms.university.model.dto.UniversityResponseDTO;

import java.util.List;

public interface UniversityService {

    List<UniversityCardDTO> getAll();

    void add(UniversityRequestDTO universityRequestDTO);

    void addFaculty(FacultyRequestDTO facultyRequestDTO);

    void addLocation(LocationRequestDTO locationRequestDTO);

    Long getFacultyCount(Long id);

    Long getForeignStudentsCount(Long id);

    List<UniversityCardDTO> getBookmarkedUniversities(Long userId);

    UniversityResponseDTO getById(String lang, Long id);

    List<RequiredDocResponseDTO> getDocsById(Long id);

    List<FacultyResponseDTO> getFacultiesByUniversityId(String lang, Long id);

    LocationResponseDTO getLocationByUniversityId(String lang, Long id);

    List<ForeignStudentResponseDTO> getForeignStudentsByUniversityId(Long id);

}
