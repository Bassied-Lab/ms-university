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
import com.bassied.ms.university.error.exceptions.NotFoundException;
import com.bassied.ms.university.mapper.UniversityMapper;
import com.bassied.ms.university.model.consts.Messages;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;
    private final FacultyRepository facultyRepository;
    private final LocationRepository locationRepository;
    private final ForeignStudentRepository foreignStudentRepository;
    private final BookmarkRepository bookmarkRepository;
    private final RequiredDocRepository requiredDocRepository;

    private final Base64Util decoder;

    @Override
    public List<UniversityCardDTO> getAll() {
        log.info("Action.getAll.start");
        log.info("Action.getAll.end");
        return universityRepository.findAll()
                .stream()
                .map(university -> universityMapper.toUniversityCardDTO(university, decoder))
                .collect(Collectors.toList());
    }

    @Override
    public Long getFacultyCount(Long id) {
        log.info("Action.getFacultyCount.start");
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Messages.UNIVERSITY_NOT_FOUND, Messages.UNIVERSITY_NOT_FOUND_MSG));
        Long facultyCount = facultyRepository.getFacultyCount(id);
        university.setFacultyCount(facultyCount);
        universityRepository.save(university);
        log.info("Action.getFacultyCount.end");
        return facultyCount;
    }

    @Override
    public Long getForeignStudentsCount(Long id) {
        log.info("Action.getForeignStudentsCount.start");
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Messages.UNIVERSITY_NOT_FOUND, Messages.UNIVERSITY_NOT_FOUND_MSG));
        Long foreignStudentCount = foreignStudentRepository.countByUniversityId(id);
        university.setForeignStudentCount(foreignStudentCount);
        universityRepository.save(university);
        log.info("Action.getForeignStudentsCount.end");
        return foreignStudentCount;
    }

    @Override
    public List<UniversityCardDTO> getBookmarkedUniversities(Long userId) {
        log.info("Action.getBookmarkedUniversities.start");
        List<Bookmark> bookmarks = bookmarkRepository.getBookmarkByUserIdAndBookmarkedIsTrue(userId);
        List<UniversityCardDTO> universityCardDTOS = new ArrayList<>();
        for (Bookmark bookmark : bookmarks) {
            University university = universityRepository.findById(bookmark.getUniversity().getId())
                    .orElseThrow(() -> new NotFoundException(
                            Messages.UNIVERSITY_NOT_FOUND, Messages.UNIVERSITY_NOT_FOUND_MSG));
            universityCardDTOS.add(universityMapper.toUniversityCardDTO(university, decoder));
        }
        log.info("Action.getBookmarkedUniversities.end");
        return universityCardDTOS;
    }

    @Override
    public UniversityResponseDTO getById(String lang, Long id) {
        log.info("Action.getById.start");
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Messages.UNIVERSITY_NOT_FOUND, Messages.UNIVERSITY_NOT_FOUND_MSG));
        if (lang.equals("az")) {
            log.info("Action.getById.end");
            return universityMapper.toUniversityResponseDTOAz(university, decoder);
        } else if (lang.equals("ru")) {
            log.info("Action.getById.end");
            return universityMapper.toUniversityResponseDTORu(university, decoder);
        } else log.info("Action.getById.end");
        return universityMapper.toUniversityResponseDTOEn(university, decoder);
    }

    @Override
    public List<RequiredDocResponseDTO> getDocsById(Long id) {
        log.info("Action.getDocsById.start");
        log.info("Action.getDocsById.end");
        return requiredDocRepository.findByUniversityId(id)
                .stream().map(universityMapper::toRequiredDocResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FacultyResponseDTO> getFacultiesByUniversityId(String lang, Long id) {
        log.info("Action.getFacultiesByUniversityId.start");
        if (lang.equals("az")) {
            log.info("Action.getFacultiesByUniversityId.end");
            return facultyRepository.findByUniversityId(id)
                    .stream()
                    .map(faculty -> universityMapper.toFacultyResponseDTOAz(faculty, decoder))
                    .collect(Collectors.toList());
        } else if (lang.equals("ru")) {
            log.info("Action.getFacultiesByUniversityId.end");
            return facultyRepository.findByUniversityId(id)
                    .stream()
                    .map(faculty -> universityMapper.toFacultyResponseDTORu(faculty, decoder))
                    .collect(Collectors.toList());
        } else log.info("Action.getFacultiesByUniversityId.end");
        return facultyRepository.findByUniversityId(id)
                .stream()
                .map(faculty -> universityMapper.toFacultyResponseDTOEn(faculty, decoder))
                .collect(Collectors.toList());
    }

    @Override
    public LocationResponseDTO getLocationByUniversityId(String lang, Long id) {
        log.info("Action.getLocationByUniversityId.start");
        Location location = locationRepository.getLocationByUniversityId(id)
                .orElseThrow(() -> new NotFoundException(
                        Messages.UNIVERSITY_NOT_FOUND, Messages.UNIVERSITY_NOT_FOUND_MSG));
        if (lang.equals("az")) {
            log.info("Action.getLocationByUniversityId.end");
            return universityMapper.toLocationResponseDTOAz(location);
        } else if (lang.equals("ru")) {
            log.info("Action.getLocationByUniversityId.end");
            return universityMapper.toLocationResponseDTORu(location);
        } else log.info("Action.getLocationByUniversityId.end");
        return universityMapper.toLocationResponseDTOEn(location);
    }

    @Override
    public List<ForeignStudentResponseDTO> getForeignStudentsByUniversityId(Long id) {
        log.info("Action.getForeignStudentsByUniversityId.start");
        log.info("Action.getForeignStudentsByUniversityId.end");
        return foreignStudentRepository.getForeignStudentByUniversityId(id)
                .stream().map(universityMapper::toForeignStudentResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void add(UniversityRequestDTO universityRequestDTO) {
        log.info("Action.add.start");
        University university = universityMapper.toUniversity(universityRequestDTO);
        university.setBase64_logo(Base64Util.encodeToString(university.getBase64_logo()));
        universityRepository.save(university);
        log.info("Action.add.end");
    }

    @Override
    public void addFaculty(FacultyRequestDTO facultyRequestDTO) {
        log.info("Action.addFaculty.start");
        Faculty faculty = universityMapper.toFaculty(facultyRequestDTO);
        faculty.setBase64_icon(Base64Util.encodeToString(faculty.getBase64_icon()));
        facultyRepository.save(faculty);
        log.info("Action.addFaculty.end");
    }

    @Override
    public void addLocation(LocationRequestDTO locationRequestDTO) {
        log.info("Action.addLocation.start");
        Location location = universityMapper.toLocation(locationRequestDTO);
        locationRepository.save(location);
        log.info("Action.addLocation.end");
    }


}
