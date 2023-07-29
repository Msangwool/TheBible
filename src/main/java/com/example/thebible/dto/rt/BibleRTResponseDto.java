package com.example.thebible.dto.rt;

import com.example.thebible.core.entity.BibleRT;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRTResponseDto {

    private String bookName;
    private int chapter;
    private int verse;
    private String content;

    @Builder
    public BibleRTResponseDto(String bookName, int chapter, int verse, String content) {
        this.bookName = bookName;
        this.chapter = chapter;
        this.verse = verse;
        this.content = content;
    }

    public static BibleRTResponseDto buildDto(BibleRT bible) {
        return BibleRTResponseDto.builder()
                .bookName(bible.getBookName())
                .chapter(bible.getChapter())
                .verse(bible.getVerse())
                .content(bible.getContent())
                .build();
    }
}
