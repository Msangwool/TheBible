package com.example.thebible.controller;

import com.example.thebible.dto.kt.BibleKTRangeChapterReqDto;
import com.example.thebible.dto.kt.BibleKTRangeReqDto;
import com.example.thebible.service.BibleKTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/bible/kt/range")
public class BibleKTSchedulerController {

    private final BibleKTService bibleService;

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀으로 등록할 절을 구간으로 작성합니다.
     *
     * @param bibleKTRangeReqDto 오늘의 성경 말씀 범위를 알 수 있는 값을 받아옵니다.
     * @return 성공했다면 200 코드를 보냅니다.
     */
    @PostMapping
    public ResponseEntity<?> uploadRangeBibles(@RequestBody BibleKTRangeReqDto bibleKTRangeReqDto) {
        bibleService.setBibleRange(bibleKTRangeReqDto);
        return ResponseEntity.ok().body(null);
    }

    /**
     * 오늘의 성경 말씀을 등록합니다.
     * <p>
     * 오늘의 성경 말씀을 장 구간으로 작성합니다.
     */
    @PostMapping("/chapter")
    public ResponseEntity<?> uploadRangeBiblesByChapter(@RequestBody BibleKTRangeChapterReqDto bibleKTRangeChapterReqDto) {
        bibleService.setBibleRangeByChapter(bibleKTRangeChapterReqDto);
        return ResponseEntity.ok().body(null);
    }
}
