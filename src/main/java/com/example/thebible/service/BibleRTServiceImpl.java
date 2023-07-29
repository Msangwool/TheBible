package com.example.thebible.service;

import com.example.thebible.core.entity.BibleRT;
import com.example.thebible.dto.rt.*;
import com.example.thebible.repository.BibleRTRepository;
import com.example.thebible.storage.BibleRTStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BibleRTServiceImpl implements BibleRTService {

    private final BibleRTRepository bibleRTRepository;
    private final BibleRTStorage bibleRTStorage;

    @Override
    public BibleRTResponseDto getBibleDetailsInfo(BibleRTRequestDto bibleRTRequestDto) {
        try {
            BibleRT bibleRT = bibleRTRepository.findByBookNameAndChapterAndVerse(bibleRTRequestDto.getBookName(), bibleRTRequestDto.getChapter(), bibleRTRequestDto.getVerse());
            return BibleRTResponseDto.buildDto(bibleRT);
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<BibleRTResponseDto> getBibleChapterList(BibleRTChapterRequestDto bibleRTChapterRequestDto) {
        try {
            return bibleRTRepository.findByBookNameAndChapter(bibleRTChapterRequestDto.getBookName(), bibleRTChapterRequestDto.getChapter()).stream().map(BibleRTResponseDto::buildDto).toList();
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void setBibleRange(BibleRTRangeReqDto bibleRangeReqDto) {

        int startVerse = bibleRangeReqDto.getStartVerse();
        int endVerse = bibleRangeReqDto.getEndVerse();
        try {
            if (startVerse > endVerse) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleRTResponseDto> bibleResponseDtoList = bibleRTRepository.findByBookNameAndChapterAndVerseBetween(bibleRangeReqDto.getBookName(), bibleRangeReqDto.getChapter(), startVerse, endVerse).stream().map(BibleRTResponseDto::buildDto).toList();

            bibleRTStorage.updateTodayBibleWords(bibleResponseDtoList, bibleRangeReqDto.isAdd());

        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public void setBibleRangeByChapter(BibleRTRangeChapterReqDto bibleRangeChapterReqDto) {

        int startChapter = bibleRangeChapterReqDto.getStartChapter();
        int endChapter = bibleRangeChapterReqDto.getEndChapter();
        try {
            if (startChapter > endChapter) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleRTResponseDto> bibleResponseDtoList = bibleRTRepository.findByBookNameAndChapterBetween(bibleRangeChapterReqDto.getBookName(), startChapter, endChapter).stream().map(BibleRTResponseDto::buildDto).toList();

            bibleRTStorage.updateTodayBibleWords(bibleResponseDtoList, bibleRangeChapterReqDto.isAdd());

        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public List<BibleRTResponseDto> getBiblesRequestRange() {
        try {
            return bibleRTStorage.getTodayBibleRTWords();
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }
}
