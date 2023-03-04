package com.bassied.ms.university.service;

import com.bassied.ms.university.dto.UniversityCardDto;
import com.bassied.ms.university.mapper.UniversityMapper;
import com.bassied.ms.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Override
    public List<UniversityCardDto> getAll() {
        return universityRepository.findAll().stream().map(universityMapper::toUniversityCardDto)
                .collect(Collectors.toList());
    }


}
