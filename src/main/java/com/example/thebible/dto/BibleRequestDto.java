package com.example.thebible.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRequestDto {

    private int book;

    private int chapter;

    private int verse;

    @Builder
    public BibleRequestDto(int book, int chapter, int verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }
}
