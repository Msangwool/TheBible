package com.example.thebible.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleChapterRequestDto {

    private int book;

    private int chapter;
}
