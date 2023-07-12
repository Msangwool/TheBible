package com.example.thebible.storage;

import com.example.thebible.dto.BibleResponseDto;

import java.util.List;

public interface BibleStorage {

    /**
     * 오늘의 성경 말씀을 조회합니다.
     *
     * @return 메모리에 저장되어 있는 오늘의 성경 말씀을 반환합니다.
     */
    List<BibleResponseDto> getTodayBibleWords();

    /**
     * 여러 사용자에게 동시에 조회되는 작업을 매번 데이터 베이스에서 진행하지 않도록, 일정 시간마다 오늘의 성경 말씀은 메모리에 적재됩니다.
     *
     * @param todayBibleWords 오늘의 성경 말씀 리스트를 받아옵니다.
     */
    void updateTodayBibleWords(List<BibleResponseDto> todayBibleWords);

    /**
     * 기존의 오늘의 말씀에 추가합니다.
     *
     * @param todayBibleWords 추가할 오늘의 말씀 구간입니다.
     */
    void addTodayBibleWords(List<BibleResponseDto> todayBibleWords);

}
