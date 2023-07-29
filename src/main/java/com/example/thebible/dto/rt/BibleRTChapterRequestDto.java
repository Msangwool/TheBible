package com.example.thebible.dto.rt;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRTChapterRequestDto {
    private String bookName;

    private int chapter;

    @Builder
    public BibleRTChapterRequestDto(String bookName, int chapter) {
        this.bookName = bookName;
        this.chapter = chapter;
    }
}
