package com.bassied.ms.university.service;


public interface BookmarkService {

    void setBookmark(Long userId, Long university_id);

    void addBookmark(Long userId, Long university_id);

    Integer getCount(Long userId);

}
