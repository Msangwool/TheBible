package com.example.thebible.repository;

import com.example.thebible.core.entity.BibleRT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibleRTRepository extends JpaRepository<BibleRT, Integer> {

    BibleRT findByBookNameAndChapterAndVerse(String bookName, int chapter, int verse);

    List<BibleRT> findByBookNameAndChapter(String bookName, int chapter);

    List<BibleRT> findByBookNameAndChapterAndVerseBetween(String bookName, int chapter, int startVerse, int endVerse);

    List<BibleRT> findByBookNameAndChapterBetween(String bookName, int startChapter, int endChapter);
}
