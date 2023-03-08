package com.bassied.ms.university.controller;

import com.bassied.ms.university.model.consts.Headers;
import com.bassied.ms.university.model.consts.URLs;
import com.bassied.ms.university.model.dto.FacultyRequestDTO;
import com.bassied.ms.university.model.dto.LocationRequestDTO;
import com.bassied.ms.university.model.dto.UniversityCardDTO;
import com.bassied.ms.university.model.dto.UniversityRequestDTO;
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
