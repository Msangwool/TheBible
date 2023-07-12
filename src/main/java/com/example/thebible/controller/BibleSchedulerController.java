package com.example.thebible.controller;

import com.example.thebible.dto.BibleRangeChapterReqDto;
import com.example.thebible.dto.BibleRangeReqDto;
import com.example.thebible.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BibleSchedulerController {

    private final BibleService bibleService;

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀으로 등록할 절을 구간으로 작성합니다.
     *
     * @param bibleRangeReqDto 오늘의 성경 말씀 범위를 알 수 있는 값을 받아옵니다.
     * @return 성공했다면 200 코드를 보냅니다.
     */
    @PostMapping("/v1/bible/range")
    public ResponseEntity<?> uploadRangeBibles(@RequestBody BibleRangeReqDto bibleRangeReqDto) {
        bibleService.setBibleRange(bibleRangeReqDto);
        return ResponseEntity.ok().body(null);
    }

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀을 장 구간으로 작성합니다.
     */
    @PostMapping("/v1/bible/range/chapter")
    public ResponseEntity<?> uploadRangeBiblesByChapter(@RequestBody BibleRangeChapterReqDto bibleRangeChapterReqDto) {
        bibleService.setBibleRangeByChapter(bibleRangeChapterReqDto);
        return ResponseEntity.ok().body(null);
    }
}
