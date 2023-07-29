package com.example.thebible.dto.kt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleKTChapterRequestDto {

    private int book;

    private int chapter;

    @Builder
    public BibleKTChapterRequestDto(int book, int chapter) {
        this.book = book;
        this.chapter = chapter;
    }
}
