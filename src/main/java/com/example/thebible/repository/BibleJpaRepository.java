package com.example.thebible.repository;

import com.example.thebible.core.entity.Bible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BibleJpaRepository extends JpaRepository<Bible, Bible.BibleId> {

    Bible findByBookAndChapterAndVerse(int book, int chapter, int verse);

    List<Bible> findByBookAndChapter(int book, int chapter);

    List<Bible> findByBookAndChapterAndVerseBetween(int book, int chapter, int startVerse, int endVerse);

    List<Bible> findByBookAndChapterBetween(int book, int startChapter, int endChapter);
}


