package com.example.thebible.core.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bible2")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BibleRT {

    @Id
    @Column(name = "idx")
    private int index;
    private int cate;
    private int book;
    private int chapter;
    @Column(name = "paragraph")
    private int verse;
    @Column(name = "sentence")
    private String content;
    private Character testament;
    @Column(name = "long_label")
    private String bookName;
    @Column(name = "short_label")
    private String bookShortName;
}
