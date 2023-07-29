package com.example.thebible.service;

import com.example.thebible.dto.rt.*;

import java.util.List;

public interface BibleRTService {

    /**
     * 성경 말씀을 검색합니다. 하나의 성경 말씀을 검색해 불러옵니다.
     * @param bibleRTRequestDto 성경 검색을 위한 Dto 를 받아옵니다.
     * @return 찾은 성경 말씀을 반환합니다.
     */
    BibleRTResponseDto getBibleDetailsInfo(BibleRTRequestDto bibleRTRequestDto);

    /**
     * 성경 말씀을 검색합니다. 몇 장인지를 통해 장 전체를 불러옵니다.
     * @param bibleRTChapterRequestDto 성경 검색을 위한 Dto 를 받아옵니다.
     * @return 찾은 성경 말씀 리스트를 반환합니다.
     */
    List<BibleRTResponseDto> getBibleChapterList(BibleRTChapterRequestDto bibleRTChapterRequestDto);

    /**
     * 특정 범위에 대한 성경 말씀을 검색합니다. 검색 후, 반환하지 않고 해당 범위의 리스트를 메모리 적재 요청합니다.
     *
     * @param bibleRangeReqDto 범위를 측정할 수 있는 값들을 요소로 받아옵니다.
     */
    void setBibleRange(BibleRTRangeReqDto bibleRangeReqDto);

    /**
     * 특정 범위에 대한 성경 말씀을 검색하고, 해당 리스트를 메모리에 올려놓습니다.
     *
     * @param bibleRangeChapterReqDto 절 구간을 가져옵니다.
     */
    void setBibleRangeByChapter(BibleRTRangeChapterReqDto bibleRangeChapterReqDto);

    /**
     * 오늘의 성경 말씀을 조회합니다.
     *
     * @return 오늘의 성경 말씀 리스트를 반환합니다.
     */
    List<BibleRTResponseDto> getBiblesRequestRange();
}
