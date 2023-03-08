package com.bassied.ms.university.dao.repository;

import com.bassied.ms.university.dao.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Optional<Bookmark> findByUserIdAndUniversityId(Long userId, Long universityId);

    Integer countByUserIdAndBookmarkedIsTrue(Long userId);

    List<Bookmark> getBookmarkByUserIdAndBookmarkedIsTrue(Long userId);

}
