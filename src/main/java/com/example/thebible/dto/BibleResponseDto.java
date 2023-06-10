package com.example.thebible.dto;

import com.example.thebible.core.entity.Bible;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleResponseDto {

    private int book;
    private int chapter;
    private int verse;
    private String content;

    @Builder
    public BibleResponseDto(int book, int chapter, int verse, String content) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.content = content;
    }

    public static BibleResponseDto buildDto(Bible bible) {
        return BibleResponseDto.builder()
                .book(bible.getBook())
                .chapter(bible.getChapter())
                .verse(bible.getVerse())
                .content(bible.getContent())
                .build();
    }
}
