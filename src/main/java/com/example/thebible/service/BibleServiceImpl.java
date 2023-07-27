package com.example.thebible.service;

import com.example.thebible.dto.*;
import com.example.thebible.repository.BibleJpaRepository;
import com.example.thebible.storage.BibleStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BibleServiceImpl implements BibleService {

    private final BibleStorage bibleStorage;
    private final BibleJpaRepository bibleJpaRepository;

    @Override
    public BibleResponseDto getBibleDetailsInfo(BibleRequestDto bibleRequestDto) {

        return BibleResponseDto.buildDto(bibleJpaRepository.findByBookAndChapterAndVerse(bibleRequestDto.getBook(), bibleRequestDto.getChapter(), bibleRequestDto.getVerse()));
    }

    @Override
    public List<BibleResponseDto> getBibleChapterList(BibleChapterRequestDto bibleChapterRequestDto) {

        return bibleJpaRepository.findByBookAndChapter(bibleChapterRequestDto.getBook(), bibleChapterRequestDto.getChapter()).stream().map(BibleResponseDto::buildDto).toList();
    }

    @Override
    public void setBibleRange(BibleRangeReqDto bibleRangeReqDto) {

        int startVerse = bibleRangeReqDto.getStartVerse();
        int endVerse = bibleRangeReqDto.getEndVerse();
        try {
            if (startVerse > endVerse) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleResponseDto> bibleResponseDtoList = bibleJpaRepository.findByBookAndChapterAndVerseBetween(bibleRangeReqDto.getBook(), bibleRangeReqDto.getChapter(), startVerse, endVerse).stream().map(BibleResponseDto::buildDto).toList();

            if (bibleRangeReqDto.isAdd()) {
                bibleStorage.addTodayBibleWords(bibleResponseDtoList);
                return;
            }

            bibleStorage.updateTodayBibleWords(bibleResponseDtoList);

        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public void setBibleRangeByChapter(BibleRangeChapterReqDto bibleRangeChapterReqDto) {

        int startChapter = bibleRangeChapterReqDto.getStartChapter();
        int endChapter = bibleRangeChapterReqDto.getEndChapter();
        try {
            if (startChapter > endChapter) {
                throw new NullPointerException("정상적이지 않은 범위입니다.");
            }

            List<BibleResponseDto> bibleResponseDtoList = bibleJpaRepository.findByBookAndChapterBetween(bibleRangeChapterReqDto.getBook(), startChapter, endChapter).stream().map(BibleResponseDto::buildDto).toList();

            if (bibleRangeChapterReqDto.isAdd()) {
                bibleStorage.addTodayBibleWords(bibleResponseDtoList);
                return;
            }

            bibleStorage.updateTodayBibleWords(bibleResponseDtoList);

        } catch (NullPointerException e) {
            log.info("NullPointerException = {}", e.getMessage());
        } catch (UnsupportedOperationException e) {
            log.info("UnsupportedOperationException = {}", e.getMessage());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
        }
    }

    @Override
    public List<BibleResponseDto> getBiblesRequestRange() {
        return bibleStorage.getTodayBibleWords();
    }
}
