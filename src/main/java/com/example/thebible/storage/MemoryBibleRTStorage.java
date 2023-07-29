package com.example.thebible.storage;

import com.example.thebible.dto.rt.BibleRTResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBibleRTStorage implements BibleRTStorage{

    protected List<BibleRTResponseDto> todayBibleRTWords = new ArrayList<>();

    public List<BibleRTResponseDto> getTodayBibleRTWords() {
        return todayBibleRTWords;
    }

    public void updateTodayBibleWords(List<BibleRTResponseDto> todayBibleRTWords, Boolean isAdd) {

        if (!isAdd) {
            this.todayBibleRTWords = new ArrayList<>();
        }

        this.todayBibleRTWords.addAll(todayBibleRTWords);
    }
}
