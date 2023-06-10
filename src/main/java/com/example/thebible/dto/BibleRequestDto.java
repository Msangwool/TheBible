package com.example.thebible.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleRequestDto {

    private int book;

    private int chapter;

    private int verse;
}
