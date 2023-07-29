package com.example.thebible.controller;

import com.example.thebible.dto.rt.BibleRTChapterRequestDto;
import com.example.thebible.dto.rt.BibleRTRequestDto;
import com.example.thebible.dto.rt.BibleRTResponseDto;
import com.example.thebible.service.BibleRTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bible/rt")
@Slf4j
public class BibleRTController {

    private final BibleRTService bibleRTService;

    /**
     * 성경 페이지로 넘어갔을 때, 기본으로 보여주는 정보입니다. (창세기 1장)
     *
     * @return 창세기 1장을 반환합니다.
     */
    @GetMapping("/init")
    public ResponseEntity<?> searchBibleInit() {
        List<BibleRTResponseDto> bibleChapterList = bibleRTService.getBibleChapterList(BibleRTChapterRequestDto.builder()
                .bookName("창세기")
                .chapter(1)
                .build());

        if (bibleChapterList == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(bibleChapterList);
    }


    @GetMapping("/verse")
    public ResponseEntity<?> searchBibleKT(@ModelAttribute BibleRTRequestDto bibleRTRequestDto) {
        BibleRTResponseDto bibleDetailsInfo = bibleRTService.getBibleDetailsInfo(bibleRTRequestDto);

        if (bibleDetailsInfo == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(bibleDetailsInfo);
    }

    /**
     * 장을 통해 성경 말씀을 반환합니다.
     *
     * @param bibleRTChapterRequestDto 성경의 장까지만 받아옵니다.
     * @return 해당 성경의 장을 모두 반환합니다.
     */
    @GetMapping("/chapter")
    public ResponseEntity<?> searchBibleByChapter(@ModelAttribute BibleRTChapterRequestDto bibleRTChapterRequestDto) {

        log.debug("bookName = {}, chapter = {}", bibleRTChapterRequestDto.getBookName(), bibleRTChapterRequestDto.getChapter());
        List<BibleRTResponseDto> bibleChapterList = bibleRTService.getBibleChapterList(bibleRTChapterRequestDto);

        if (bibleChapterList == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(bibleChapterList);
    }

    /**
     * 오늘의 말씀을 찾습니다.
     *
     * @return 오늘의 말씀은 DataBase 에서 메모리에 올라와 있는 상태입니다. 해당 메모리에 존재하는 오늘의 말씀을 반환합니다.
     */
    @GetMapping("/today")
    public ResponseEntity<?> searchBibles() {
        List<BibleRTResponseDto> biblesRequestRange = bibleRTService.getBiblesRequestRange();

        if (biblesRequestRange == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(biblesRequestRange);
    }
}