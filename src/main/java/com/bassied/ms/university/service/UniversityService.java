package com.bassied.ms.university.service;


import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;

import java.util.List;

public interface UniversityService {

    List<UniversityCardDTO> getAll();

    void add(UniversityRequestDTO universityRequestDTO);

    void addFaculty(FacultyRequestDTO facultyRequestDTO);

    void addLocation(LocationRequestDTO locationRequestDTO);

    Long getFacultyCount(Long id);

    Long getForeignStudentsCount(Long id);

    List<UniversityCardDTO> getBookmarkedUniversities(Long userId);

}
