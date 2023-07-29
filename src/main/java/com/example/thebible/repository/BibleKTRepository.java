package com.example.thebible.repository;

import com.example.thebible.core.entity.BibleKT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BibleKTRepository extends JpaRepository<BibleKT, BibleKT.BibleId> {

    BibleKT findByBookAndChapterAndVerse(int book, int chapter, int verse);

    List<BibleKT> findByBookAndChapter(int book, int chapter);

    List<BibleKT> findByBookAndChapterAndVerseBetween(int book, int chapter, int startVerse, int endVerse);

    List<BibleKT> findByBookAndChapterBetween(int book, int startChapter, int endChapter);
}


