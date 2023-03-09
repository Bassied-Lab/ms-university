package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> getLocationByUniversityId(Long id);

}
