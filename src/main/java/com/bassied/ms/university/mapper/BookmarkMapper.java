package com.bassied.ms.university.mapper;

import com.bassied.ms.university.dao.entity.Bookmark;
import com.bassied.ms.university.model.dto.BookmarkRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookmarkMapper {
    @Mapping(target = "university.id", source = "universityId")
    Bookmark toBookmark(BookmarkRequestDTO bookmarkRequestDTO);

}
