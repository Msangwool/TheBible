package com.example.thebible.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRangeReqDto {

    private int book;
    private int chapter;
    private int startVerse;
    private int endVerse;
    private boolean isAdd;

    @Builder
    public BibleRangeReqDto(int book, int chapter, int startVerse, int endVerse, boolean isAdd) {
        this.book = book;
        this.chapter = chapter;
        this.startVerse = startVerse;
        this.endVerse = endVerse;
        this.isAdd = isAdd;
    }
}
