package com.bassied.ms.university.model.dto;

public record BookmarkRequestDTO(Long userId,
                                 Long universityId,
                                 boolean bookmarked) {
}
