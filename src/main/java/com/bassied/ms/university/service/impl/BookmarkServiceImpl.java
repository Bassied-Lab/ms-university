package com.bassied.ms.university.service.impl;

import com.bassied.ms.university.dao.entity.Bookmark;
import com.bassied.ms.university.dao.repository.BookmarkRepository;
import com.bassied.ms.university.mapper.BookmarkMapper;
import com.bassied.ms.university.model.dto.BookmarkRequestDTO;
import com.bassied.ms.university.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkMapper bookmarkMapper;

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void setBookmark(Long userId, Long university_id) {
        log.info("Action.setBookmark.start");
        Optional<Bookmark> bookmarkOptional = bookmarkRepository.findByUserIdAndUniversityId(userId, university_id);
        if (!bookmarkOptional.isPresent()) {
            addBookmark(userId, university_id);
        } else {
            Bookmark bookmark = bookmarkOptional.get();
            bookmark.setBookmarked(!bookmark.isBookmarked());
            bookmarkRepository.save(bookmark);
        }
        log.info("Action.setBookmark.end");
    }

    @Override
    public void addBookmark(Long userId, Long university_id) {
        log.info("Action.addBookmark.start");
        BookmarkRequestDTO bookmarkRequestDTO = new BookmarkRequestDTO(userId, university_id, true);
        Bookmark bookmark = bookmarkMapper.toBookmark(bookmarkRequestDTO);
        bookmarkRepository.save(bookmark);
        log.info("Action.addBookmark.end");
    }

    @Override
    public Integer getCount(Long userId) {
        log.info("Action.getCount.start");
        log.info("Action.getCount.end");
        return bookmarkRepository.countByUserIdAndBookmarkedIsTrue(userId);
    }

}
