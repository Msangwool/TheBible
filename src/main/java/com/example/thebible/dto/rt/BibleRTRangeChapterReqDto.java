package com.example.thebible.dto.rt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRTRangeChapterReqDto {

    private String bookName;
    private int startChapter;
    private int endChapter;
    private boolean isAdd;

    @Builder
    public BibleRTRangeChapterReqDto(String bookName, int startChapter, int endChapter, boolean isAdd) {
        this.bookName = bookName;
        this.startChapter = startChapter;
        this.endChapter = endChapter;
        this.isAdd = isAdd;
    }
}
