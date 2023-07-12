package com.example.thebible.service;

import com.example.thebible.dto.*;
import com.example.thebible.repository.BibleRepository;
import com.example.thebible.storage.BibleStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BibleServiceImpl implements BibleService {

    private final BibleStorage bibleStorage;
    private final BibleRepository bibleRepository;

    public BibleResponseDto getBibleDetailsInfo(BibleRequestDto bibleRequestDto) {
        return BibleResponseDto.buildDto(bibleRepository.findBible(bibleRequestDto));
    }

    public List<BibleResponseDto> getBibleChapterList(BibleChapterRequestDto bibleChapterRequestDto) {
        return bibleRepository.findBiblesByChapter(bibleChapterRequestDto).stream().map(BibleResponseDto::buildDto).toList();
    }

    public void setBibleRange(BibleRangeReqDto bibleRangeReqDto) {
        int startPoint = bibleRangeReqDto.getStartVerse();
        int endPoint = bibleRangeReqDto.getEndVerse();
        try {
            if (startPoint > endPoint) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        }

        BibleRequestDto bibleRequestDto = BibleRequestDto.builder()
                .book(bibleRangeReqDto.getBook())
                .chapter(bibleRangeReqDto.getChapter())
                .build();

        List<BibleResponseDto> bibleResponseDtoList = new ArrayList<>();
        while (startPoint <= endPoint) {

            bibleRequestDto.setVerse(startPoint);
            bibleResponseDtoList.add(BibleResponseDto.buildDto(bibleRepository.findBible(bibleRequestDto)));

            startPoint++;
        }

        if (bibleRangeReqDto.isAdd()) {
            bibleStorage.addTodayBibleWords(bibleResponseDtoList);
            return;
        }

        bibleStorage.updateTodayBibleWords(bibleResponseDtoList);
    }

    public void setBibleRangeByChapter(BibleRangeChapterReqDto bibleRangeChapterReqDto) {
        int startPoint = bibleRangeChapterReqDto.getStartChapter();
        int endPoint = bibleRangeChapterReqDto.getEndChapter();
        try {
            if (startPoint > endPoint) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        }

        BibleChapterRequestDto bibleChapterRequestDto = BibleChapterRequestDto.builder()
                .book(bibleRangeChapterReqDto.getBook())
                .build();

        List<BibleResponseDto> bibleResponseDtoList = new ArrayList<>();
        while (startPoint <= endPoint) {

            bibleChapterRequestDto.setChapter(startPoint);
            bibleResponseDtoList.addAll(bibleRepository.findBiblesByChapter(bibleChapterRequestDto).stream().map(BibleResponseDto::buildDto).toList());

            startPoint++;
        }

        if (bibleRangeChapterReqDto.isAdd()) {
            bibleStorage.addTodayBibleWords(bibleResponseDtoList);
        }

        bibleStorage.updateTodayBibleWords(bibleResponseDtoList);
    }

    public List<BibleResponseDto> getBiblesRequestRange() {
        return bibleStorage.getTodayBibleWords();
    }
}
