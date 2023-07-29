package com.example.thebible.dto.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleKTRangeChapterReqDto {

    private int book;
    private int startChapter;
    private int endChapter;
    private boolean isAdd;

    @Builder
    public BibleKTRangeChapterReqDto(int book, int startChapter, int endChapter, boolean isAdd) {
        this.book = book;
        this.startChapter = startChapter;
        this.endChapter = endChapter;
        this.isAdd = isAdd;
    }
}
