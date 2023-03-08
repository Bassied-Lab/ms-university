package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.ForeignStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ForeignStudentRepository extends JpaRepository<ForeignStudent, Long> {

    @Query(value = "select sum(fs.count) from foreign_students as fs\n" +
            "where university_id=:id", nativeQuery = true)
    Long countByUniversityId(Long id);

}
