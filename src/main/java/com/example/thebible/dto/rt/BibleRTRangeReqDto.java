package com.example.thebible.dto.rt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRTRangeReqDto {

    private String bookName;
    private int chapter;
    private int startVerse;
    private int endVerse;
    private boolean isAdd;

    @Builder
    public BibleRTRangeReqDto(String bookName, int chapter, int startVerse, int endVerse, boolean isAdd) {
        this.bookName = bookName;
        this.chapter = chapter;
        this.startVerse = startVerse;
        this.endVerse = endVerse;
        this.isAdd = isAdd;
    }
}
