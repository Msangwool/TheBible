package com.example.thebible.controller;

import com.example.thebible.dto.rt.BibleRTRangeChapterReqDto;
import com.example.thebible.dto.rt.BibleRTRangeReqDto;
import com.example.thebible.service.BibleRTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bible/rt/range")
@Slf4j
public class BibleRTSchedulerController {

    private final BibleRTService bibleRTService;

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀으로 등록할 절을 구간으로 작성합니다.
     *
     * @param bibleRTRangeReqDto 오늘의 성경 말씀 범위를 알 수 있는 값을 받아옵니다.
     * @return 성공했다면 200 코드를 보냅니다.
     */
    @PostMapping
    public ResponseEntity<?> uploadRangeBibles(@RequestBody BibleRTRangeReqDto bibleRTRangeReqDto) {
        try {
            bibleRTService.setBibleRange(bibleRTRangeReqDto);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀을 장 구간으로 작성합니다.
     */
    @PostMapping("/chapter")
    public ResponseEntity<?> uploadRangeBiblesByChapter(@RequestBody BibleRTRangeChapterReqDto bibleRTRangeChapterReqDto) {
        try {
            bibleRTService.setBibleRangeByChapter(bibleRTRangeChapterReqDto);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
