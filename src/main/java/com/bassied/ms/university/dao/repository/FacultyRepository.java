package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Query(value = "SELECT COUNT(*) AS faculty_count\n" +
            "FROM faculties_universities fu\n" +
            "JOIN faculties f ON f.id = fu.faculty_id\n" +
            "WHERE fu.university_id = :id", nativeQuery = true)
    Long getFacultyCount(@Param("id") Long id);

    @Query(value = "SELECT * FROM faculties f \n" +
            "JOIN faculties_universities fu ON f.id = fu.faculty_id\n" +
            "WHERE fu.university_id  =:id", nativeQuery = true)
    List<Faculty> findByUniversityId(Long id);


}
