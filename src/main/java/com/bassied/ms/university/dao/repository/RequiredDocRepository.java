package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.RequiredDoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequiredDocRepository extends JpaRepository<RequiredDoc, Long> {

    List<RequiredDoc> findByUniversityId(Long id);

}
