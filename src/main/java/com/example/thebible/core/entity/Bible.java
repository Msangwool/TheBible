package com.example.thebible.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bible_korHRV")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bible {

    @Id
    @Column(name = "book")
    private int book;

    @Column(name = "chapter")
    private int chapter;

    @Column(name = "verse")
    private int verse;

    @Column(name = "content")
    private String content;
}
