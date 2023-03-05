package com.bassied.ms.university.controller;

import com.bassied.ms.university.consts.URLs;
import com.bassied.ms.university.dto.UniversityCardDTO;
import com.bassied.ms.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
        return ResponseEntity.ok().body(universityService.getAll());
    }

}
