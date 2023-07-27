package com.example.thebible.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleChapterRequestDto {

    private int book;

    private int chapter;

    @Builder
    public BibleChapterRequestDto(int book, int chapter) {
        this.book = book;
        this.chapter = chapter;
    }
}
