package com.example.thebible.dto.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleKTRequestDto {

    private int book;

    private int chapter;

    private int verse;

    @Builder
    public BibleKTRequestDto(int book, int chapter, int verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }
}
