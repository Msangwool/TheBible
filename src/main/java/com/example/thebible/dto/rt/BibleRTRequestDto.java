package com.example.thebible.dto.rt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRTRequestDto {

    private String bookName;

    private int chapter;

    private int verse;

    @Builder
    public BibleRTRequestDto(String bookName, int chapter, int verse) {
        this.bookName = bookName;
        this.chapter = chapter;
        this.verse = verse;
    }
}
