package com.bassied.ms.university.controller;

import com.bassied.ms.university.model.consts.Headers;
import com.bassied.ms.university.model.consts.URLs;
import com.bassied.ms.university.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(URLs.BOOKMARK)
public class BookMarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/count")
    public Integer count(@RequestHeader(Headers.USER_ID) Long userId) {
        return bookmarkService.count(userId);
    }

    @PostMapping("/universities/{universityId}")
    public void setBookmark(@RequestHeader(Headers.USER_ID) Long userId, @PathVariable Long universityId) {
        bookmarkService.setBookmark(userId, universityId);
    }


}
