package com.example.thebible.dto.kt;

import com.example.thebible.core.entity.BibleKT;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleKTResponseDto {

    private int book;
    private int chapter;
    private int verse;
    private String content;

    @Builder
    public BibleKTResponseDto(int book, int chapter, int verse, String content) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.content = content;
    }

    public static BibleKTResponseDto buildDto(BibleKT bible) {
        return BibleKTResponseDto.builder()
                .book(bible.getBook())
                .chapter(bible.getChapter())
                .verse(bible.getVerse())
                .content(bible.getContent())
                .build();
    }
}
