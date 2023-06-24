package com.example.thebible.service;

import com.example.thebible.dto.BibleChapterRequestDto;
import com.example.thebible.dto.BibleRequestDto;
import com.example.thebible.dto.BibleResponseDto;
import com.example.thebible.repository.BibleRepository;
import com.example.thebible.storage.BibleStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibleServiceImpl implements BibleService {

    private final BibleStorage bibleStorage;
    private final BibleRepository bibleRepository;

    public BibleResponseDto getBibleDetailsInfo(BibleRequestDto bibleRequestDto) {
        return BibleResponseDto.buildDto(bibleRepository.findBible(bibleRequestDto));
    }

    public List<BibleResponseDto> getBibleChapterList(BibleChapterRequestDto bibleChapterRequestDto) {
        return bibleRepository.findBiblesByChapter(bibleChapterRequestDto).stream().map(BibleResponseDto::buildDto).toList();
    }

    public void setBiblesRequestRange(List<BibleRequestDto> bibleRequestDtoList) {
        List<BibleResponseDto> bibleResponseDtoList = bibleRepository.findBiblesByRange(bibleRequestDtoList).stream().map(BibleResponseDto::buildDto).toList();
        bibleStorage.updateTodayBibleWords(bibleResponseDtoList);
    }

    public List<BibleResponseDto> getBiblesRequestRange() {
        return bibleStorage.getTodayBibleWords();
    }
}
