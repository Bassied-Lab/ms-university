package com.bassied.ms.university.controller;

import com.bassied.ms.university.dto.UniversityCardDto;
import com.bassied.ms.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public List<UniversityCardDto> getAll() {
        return universityService.getAll();
    }

}
