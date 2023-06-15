package com.example.thebible.repository;

import com.example.thebible.core.entity.Bible;
import com.example.thebible.dto.BibleChapterRequestDto;
import com.example.thebible.dto.BibleRequestDto;

import java.util.List;

public interface BibleRepository {

    /**
     * 성경 말씀을 찾습니다.
     * @param bibleSearchDto 성경 말씀을 찾기 위해 필요한 정보가 담겨있습니다. (book, chapter, verse)
     * @return 찾은 성경을 Bible 타입으로 반환합니다.
     */
    Bible findBible(BibleRequestDto bibleSearchDto);

    /**
     * 특정 범위의 성경 말씀을 찾습니다.
     * @param bibleRequestDtoList 찾을 성경 말씀 범위를 리스트로 받습니다. (각 내부에 들어있는 정보는 book, chapter, verse 입니다.)
     * @return 해당 범위의 모든 성경 말씀을 찾아 반환합니다.
     */
    List<Bible> findBiblesByRange(List<BibleRequestDto> bibleRequestDtoList);

    /**
     * 요청된 장에 해당하는 모든 성경 말씀을 찾습니다.
     * @param bibleChapterRequestDto 성경 말씀을 찾기 위한 정보가 담겨있습니다. (book, chapter)
     * @return 찾은 모든 절을 반환합니다.
     */
    List<Bible> findBiblesByChapter(BibleChapterRequestDto bibleChapterRequestDto);
}
