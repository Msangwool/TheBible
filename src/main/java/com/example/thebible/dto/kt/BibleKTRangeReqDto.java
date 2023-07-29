package com.example.thebible.dto.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleKTRangeReqDto {

    private int book;
    private int chapter;
    private int startVerse;
    private int endVerse;
    private boolean isAdd;

    @Builder
    public BibleKTRangeReqDto(int book, int chapter, int startVerse, int endVerse, boolean isAdd) {
        this.book = book;
        this.chapter = chapter;
        this.startVerse = startVerse;
        this.endVerse = endVerse;
        this.isAdd = isAdd;
    }
}
