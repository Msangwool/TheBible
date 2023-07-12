package com.example.thebible.storage;

import com.example.thebible.dto.BibleResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBibleStorage implements BibleStorage{

    protected List<BibleResponseDto> todayBibleWords = new ArrayList<>();

    public List<BibleResponseDto> getTodayBibleWords() {
        return todayBibleWords;
    }

    public void updateTodayBibleWords(List<BibleResponseDto> todayBibleWords) {
        this.todayBibleWords = todayBibleWords;
    }

    public void addTodayBibleWords(List<BibleResponseDto> todayBibleWords) {
        this.todayBibleWords.addAll(todayBibleWords);
    }
}
