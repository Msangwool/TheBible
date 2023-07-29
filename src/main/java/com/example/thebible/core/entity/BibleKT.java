package com.example.thebible.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "bible_korHRV")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BibleKT.BibleId.class)
public class BibleKT {

    @Id
    private int book;
    @Id
    private int chapter;
    @Id
    private int verse;
    private String content;

    @Embeddable
    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor(staticName = "of")
    public static class BibleId implements Serializable {

        @NonNull
        private int book;

        @NonNull
        private int chapter;

        @NonNull
        private int verse;

    }
}
