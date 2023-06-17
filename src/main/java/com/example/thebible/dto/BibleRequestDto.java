package com.example.thebible.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BibleRequestDto {

    private int book;

    private int chapter;

    private int verse;
}
