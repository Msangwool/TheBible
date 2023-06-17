package com.example.thebible.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BibleChapterRequestDto {

    private int book;

    private int chapter;
}
