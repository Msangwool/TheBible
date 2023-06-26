package com.example.thebible.controller;

import com.example.thebible.dto.BibleChapterRequestDto;
import com.example.thebible.dto.BibleRequestDto;
import com.example.thebible.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BibleController {

    private final BibleService bibleService;

    /**
     * 성경 페이지로 넘어갔을 때, 기본으로 보여주는 정보입니다. (창세기 1장)
     *
     * @return 창세기 1장을 반환합니다.
     */
    @GetMapping("/v1/bible/init")
    public ResponseEntity<?> searchBibleInit() {
        return ResponseEntity.ok().body(bibleService.getBibleChapterList(BibleChapterRequestDto.builder()
                .book(1)
                .chapter(1)
                .build()));
    }

    /**
     * 특정 하나의 성경 말씀을 불러옵니다.
     *
     * @param bibleRequestDto 성경 말씀을 찾을 수 있는 정보를 받아옵니다.
     * @return 말씀, 장, 절에 해당하는 하나의 말씀을 반환합니다.
     */
    @GetMapping("/v1/bible/verse")
    public ResponseEntity<?> searchBible(@RequestBody BibleRequestDto bibleRequestDto) {
        return ResponseEntity.ok().body(bibleService.getBibleDetailsInfo(bibleRequestDto));
    }

    /**
     * 장을 통해 성경 말씀을 반환합니다.
     *
     * @param bibleChapterRequestDto 성경의 장까지만 받아옵니다.
     * @return 해당 성경의 장을 모두 반환합니다.
     */
    @GetMapping("/v1/bible/chapter")
    public ResponseEntity<?> searchBibleByChapter(@RequestBody BibleChapterRequestDto bibleChapterRequestDto) {
        return ResponseEntity.ok().body(bibleService.getBibleChapterList(bibleChapterRequestDto));
    }

    /**
     * 오늘의 말씀을 찾습니다.
     *
     * @return 오늘의 말씀은 DataBase 에서 메모리에 올라와 있는 상태입니다. 해당 메모리에 존재하는 오늘의 말씀을 반환합니다.
     */
    @GetMapping("/v1/bible/today")
    public ResponseEntity<?> searchBibles() {
        return ResponseEntity.ok().body(bibleService.getBiblesRequestRange());
    }
}
