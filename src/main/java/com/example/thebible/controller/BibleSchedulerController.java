package com.example.thebible.controller;

import com.example.thebible.dto.BibleRequestDto;
import com.example.thebible.service.BibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BibleSchedulerController {

    private final BibleService bibleService;

    /**
     * 오늘의 성경 말씀을 등록합니다.
     *
     * @param bibleRequestDtoList 오늘의 성경 말씀에 해당하는 모든 절을 받아옵니다.
     * @return 성공하면 200 코드를 보냅니다.
     */
    @PostMapping("/v1/bible/range")
    public ResponseEntity<?> searchBibles(@RequestBody List<BibleRequestDto> bibleRequestDtoList) {
        bibleService.setBiblesRequestRange(bibleRequestDtoList);
        return ResponseEntity.ok().body(null);
    }
}
