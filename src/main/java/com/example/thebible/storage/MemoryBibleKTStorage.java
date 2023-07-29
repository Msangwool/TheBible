package com.example.thebible.storage;

import com.example.thebible.dto.kt.BibleKTResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBibleKTStorage implements BibleKTStorage {

    protected List<BibleKTResponseDto> todayBibleWords = new ArrayList<>();

    public List<BibleKTResponseDto> getTodayBibleWords() {
        return todayBibleWords;
    }

    public void updateTodayBibleWords(List<BibleKTResponseDto> todayBibleWords, Boolean isAdd) {

        if (!isAdd) {
            this.todayBibleWords = new ArrayList<>();
        }

        this.todayBibleWords.addAll(todayBibleWords);
    }
}
