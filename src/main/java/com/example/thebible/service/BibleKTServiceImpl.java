package com.example.thebible.service;

import com.example.thebible.core.entity.BibleRT;
import com.example.thebible.dto.kt.*;
import com.example.thebible.dto.rt.BibleRTResponseDto;
import com.example.thebible.repository.BibleKTRepository;
import com.example.thebible.storage.BibleStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BibleKTServiceImpl implements BibleKTService {

    private final BibleStorage bibleStorage;
    private final BibleKTRepository bibleJpaRepository;

    @Override
    public BibleKTResponseDto getBibleDetailsInfo(BibleKTRequestDto bibleRequestDto) {
        try {
            return BibleKTResponseDto.buildDto(bibleJpaRepository.findByBookAndChapterAndVerse(bibleRequestDto.getBook(), bibleRequestDto.getChapter(), bibleRequestDto.getVerse()));
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
    public List<BibleKTResponseDto> getBibleChapterList(BibleKTChapterRequestDto bibleChapterRequestDto) {
        try {
            return bibleJpaRepository.findByBookAndChapter(bibleChapterRequestDto.getBook(), bibleChapterRequestDto.getChapter()).stream().map(BibleKTResponseDto::buildDto).toList();
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
    public void setBibleRange(BibleKTRangeReqDto bibleRangeReqDto) {

        int startVerse = bibleRangeReqDto.getStartVerse();
        int endVerse = bibleRangeReqDto.getEndVerse();
        try {
            if (startVerse > endVerse) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleKTResponseDto> bibleResponseDtoList = bibleJpaRepository.findByBookAndChapterAndVerseBetween(bibleRangeReqDto.getBook(), bibleRangeReqDto.getChapter(), startVerse, endVerse).stream().map(BibleKTResponseDto::buildDto).toList();

            bibleStorage.updateTodayBibleWords(bibleResponseDtoList, bibleRangeReqDto.isAdd());

        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public void setBibleRangeByChapter(BibleKTRangeChapterReqDto bibleRangeChapterReqDto) {

        int startChapter = bibleRangeChapterReqDto.getStartChapter();
        int endChapter = bibleRangeChapterReqDto.getEndChapter();
        try {
            if (startChapter > endChapter) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleKTResponseDto> bibleResponseDtoList = bibleJpaRepository.findByBookAndChapterBetween(bibleRangeChapterReqDto.getBook(), startChapter, endChapter).stream().map(BibleKTResponseDto::buildDto).toList();

            bibleStorage.updateTodayBibleWords(bibleResponseDtoList, bibleRangeChapterReqDto.isAdd());
        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public List<BibleKTResponseDto> getBiblesRequestRange() {
        try {
            return bibleStorage.getTodayBibleWords();
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
