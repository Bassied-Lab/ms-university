package com.bassied.ms.university.service;

import com.bassied.ms.university.dto.UniversityCardDTO;
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
    public List<UniversityCardDTO> getAll() {
        return null;
    }

}
