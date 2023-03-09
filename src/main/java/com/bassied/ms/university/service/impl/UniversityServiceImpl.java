package com.bassied.ms.university.service.impl;

import com.bassied.ms.university.dao.entity.Bookmark;
import com.bassied.ms.university.dao.entity.Faculty;
import com.bassied.ms.university.dao.entity.Location;
import com.bassied.ms.university.dao.entity.University;
import com.bassied.ms.university.dao.repository.BookmarkRepository;
import com.bassied.ms.university.dao.repository.FacultyRepository;
import com.bassied.ms.university.dao.repository.ForeignStudentRepository;
import com.bassied.ms.university.dao.repository.LocationRepository;
import com.bassied.ms.university.dao.repository.RequiredDocRepository;
import com.bassied.ms.university.dao.repository.UniversityRepository;
import com.bassied.ms.university.mapper.UniversityMapper;
import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.FacultyResponseDTO;
import com.bassied.ms.university.model.dto.ForeignStudentResponseDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.LocationResponseDTO;
import com.bassied.ms.university.model.dto.RequiredDocResponseDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;
import com.bassied.ms.university.model.dto.UniversityResponseDTO;
import com.bassied.ms.university.service.UniversityService;
import com.bassied.ms.university.util.Base64Util;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;
    private final FacultyRepository facultyRepository;
    private final LocationRepository locationRepository;
    private final ForeignStudentRepository foreignStudentRepository;
    private final BookmarkRepository bookmarkRepository;
    private final RequiredDocRepository requiredDocRepository;

    @Override
    public List<UniversityCardDTO> getAll() {
        Base64Util decoder = new Base64Util();
        return universityRepository.findAll()
                .stream()
                .map(university -> universityMapper.toUniversityCardDTO(university, decoder))
                .collect(Collectors.toList());
    }

    @Override
    public Long getFacultyCount(Long id) {
        University university = universityRepository.findById(id).orElseThrow();
        Long facultyCount = facultyRepository.getFacultyCount(id);
        university.setFacultyCount(facultyCount);
        universityRepository.save(university);
        return facultyCount;
    }

    @Override
    public Long getForeignStudentsCount(Long id) {
        University university = universityRepository.findById(id).orElseThrow();
        Long foreignStudentCount = foreignStudentRepository.countByUniversityId(id);
        university.setForeignStudentCount(foreignStudentCount);
        universityRepository.save(university);
        return foreignStudentCount;
    }

    @Override
    public List<UniversityCardDTO> getBookmarkedUniversities(Long userId) {
        List<Bookmark> bookmarks = bookmarkRepository.getBookmarkByUserIdAndBookmarkedIsTrue(userId);
        Base64Util decoder = new Base64Util();
        List<UniversityCardDTO> universityCardDTOS = new ArrayList<>();
        for (Bookmark bookmark : bookmarks) {
            University university = universityRepository.findById(bookmark.getUniversity().getId()).orElseThrow();
            universityCardDTOS.add(universityMapper.toUniversityCardDTO(university, decoder));
        }
        return universityCardDTOS;
    }

    @Override
    public UniversityResponseDTO getById(String lang, Long id) {
        University university = universityRepository.findById(id).orElseThrow();
        Base64Util decoder = new Base64Util();
        if (lang.equals("az")) {
            return universityMapper.toUniversityResponseDTOAz(university, decoder);
        } else if (lang.equals("ru")) {
            return universityMapper.toUniversityResponseDTORu(university, decoder);
        } else return universityMapper.toUniversityResponseDTOEn(university, decoder);
    }

    @Override
    public List<RequiredDocResponseDTO> getDocsById(Long id) {
        return requiredDocRepository.findByUniversityId(id).stream().map(universityMapper::toRequiredDocResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyResponseDTO> getFacultiesByUniversityId(String lang, Long id) {
        Base64Util decoder = new Base64Util();
        if (lang.equals("az")) {
            return facultyRepository.findByUniversityId(id)
                    .stream()
                    .map(faculty -> universityMapper.toFacultyResponseDTOAz(faculty, decoder))
                    .collect(Collectors.toList());
        } else if (lang.equals("ru")) {
            return facultyRepository.findByUniversityId(id)
                    .stream()
                    .map(faculty -> universityMapper.toFacultyResponseDTORu(faculty, decoder))
                    .collect(Collectors.toList());
        } else return facultyRepository.findByUniversityId(id)
                .stream()
                .map(faculty -> universityMapper.toFacultyResponseDTOEn(faculty, decoder))
                .collect(Collectors.toList());
    }

    @Override
    public LocationResponseDTO getLocationByUniversityId(String lang, Long id) {
        Location location = locationRepository.getLocationByUniversityId(id);
        if (lang.equals("az")) {
            return universityMapper.toLocationResponseDTOAz(location);
        } else if (lang.equals("ru")) {
            return universityMapper.toLocationResponseDTORu(location);
        } else return universityMapper.toLocationResponseDTOEn(location);
    }

    @Override
    public List<ForeignStudentResponseDTO> getForeignStudentsByUniversityId(Long id) {
        return foreignStudentRepository.getForeignStudentByUniversityId(id)
                .stream().map(universityMapper::toForeignStudentResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void add(UniversityRequestDTO universityRequestDTO) {
        University university = universityMapper.toUniversity(universityRequestDTO);
        university.setBase64_logo(Base64Util.encodeToString(university.getBase64_logo()));
        universityRepository.save(university);
    }

    @Override
    public void addFaculty(FacultyRequestDTO facultyRequestDTO) {
        Faculty faculty = universityMapper.toFaculty(facultyRequestDTO);
        faculty.setBase64_icon(Base64Util.encodeToString(faculty.getBase64_icon()));
        facultyRepository.save(faculty);
    }

    @Override
    public void addLocation(LocationRequestDTO locationRequestDTO) {
        Location location = universityMapper.toLocation(locationRequestDTO);
        locationRepository.save(location);
    }


}
