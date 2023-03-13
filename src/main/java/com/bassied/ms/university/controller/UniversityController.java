package com.bassied.ms.university.controller;

import com.bassied.ms.university.model.consts.Headers;
import com.bassied.ms.university.model.consts.URLs;
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
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(URLs.ROOT)
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/list")
    public ResponseEntity<List<UniversityCardDTO>> getAll() {
        return ResponseEntity.ok(universityService.getAll());
    }

    @GetMapping("/faculty-count/{id}")
    public ResponseEntity<Long> getFacultyCount(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.getFacultyCount(id));
    }

    @GetMapping("/foreign-student-count/{id}")
    public ResponseEntity<Long> getForeignStudentsCount(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.getForeignStudentsCount(id));
    }

    @GetMapping("/bookmarked-universities")
    public ResponseEntity<List<UniversityCardDTO>> getBookmarkedUniversities(
            @RequestHeader(Headers.USER_ID) Long userId) {
        return ResponseEntity.ok(universityService.getBookmarkedUniversities(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponseDTO> getById(
            @RequestHeader(Headers.LANGUAGE) String lang,
            @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getById(lang, id));
    }


    @GetMapping("/faculty/{id}")
    public ResponseEntity<List<FacultyResponseDTO>> getFacultiesByUniversityId(
            @RequestHeader(Headers.LANGUAGE) String lang,
            @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getFacultiesByUniversityId(lang, id));
    }

    @GetMapping("/required-documents/{id}")
    public ResponseEntity<List<RequiredDocResponseDTO>> getDocsByUniversityId(
            @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getDocsById(id));
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<LocationResponseDTO> getLocationByUniversityId(
            @RequestHeader(Headers.LANGUAGE) String lang,
            @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getLocationByUniversityId(lang, id));
    }

    @GetMapping("/foreign-students/{id}")
    public ResponseEntity<List<ForeignStudentResponseDTO>> getForeignStudentsByUniversityId(
            @PathVariable Long id) {
        return ResponseEntity.ok(universityService.getForeignStudentsByUniversityId(id));
    }

    @PostMapping
    public void add(@RequestBody UniversityRequestDTO universityRequestDTO) {
        universityService.add(universityRequestDTO);
    }

    @PostMapping("/faculty")
    public void addFaculty(@RequestBody FacultyRequestDTO facultyRequestDTO) {
        universityService.addFaculty(facultyRequestDTO);
    }

    @PostMapping("/location")
    public void addLocation(@RequestBody LocationRequestDTO locationRequestDTO) {
        universityService.addLocation(locationRequestDTO);
    }


}
