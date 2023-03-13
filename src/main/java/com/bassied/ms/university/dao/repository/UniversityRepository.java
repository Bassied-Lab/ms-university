package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
