package com.example.thebible.repository;


import com.example.thebible.core.entity.Bible;
import com.example.thebible.dto.BibleChapterRequestDto;
import com.example.thebible.dto.BibleRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest
public class JpaBibleRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private StringBuilder stringBuilder;

    @Test
    public void findBible() {
        stringBuilder = new StringBuilder();
        BibleRequestDto bibleRequestDto = new BibleRequestDto(1, 1, 1);

        Bible bible = getBible(bibleRequestDto);

        stringBuilder.append("----------------Bible----------------\n");
        stringBuilder.append("Book\t: ").append(Objects.requireNonNull(bible).getBook()).append("\n");
        stringBuilder.append("Chapter\t: ").append(Objects.requireNonNull(bible).getChapter()).append("\n");
        stringBuilder.append("Verse\t: ").append(Objects.requireNonNull(bible).getVerse()).append("\n");
        stringBuilder.append("Content\t: ").append(Objects.requireNonNull(bible).getContent()).append("\n");

        System.out.println(stringBuilder);
    }

    @Test
    public void findBiblesByChapter() {
        stringBuilder = new StringBuilder();
        BibleChapterRequestDto bibleChapterRequestDto = new BibleChapterRequestDto(1, 1);

        String getBibleQuery = "select * from bible_korHRV where book = ? and chapter = ?";
        int getBookBySearchDto = bibleChapterRequestDto.getBook();
        int getChapterBySearchDto = bibleChapterRequestDto.getChapter();

        List<Bible> bibles = this.jdbcTemplate.query(
                getBibleQuery,
                (rs, rowNum) -> new Bible(
                        rs.getInt("book"),
                        rs.getInt("chapter"),
                        rs.getInt("verse"),
                        rs.getString("content")
                ),
                getBookBySearchDto, getChapterBySearchDto);

        bibles.forEach(bible -> {
            stringBuilder.append("----------------Bible----------------\n");
            stringBuilder.append("Book\t: ").append(Objects.requireNonNull(bible).getBook()).append("\n");
            stringBuilder.append("Chapter\t: ").append(Objects.requireNonNull(bible).getChapter()).append("\n");
            stringBuilder.append("Verse\t: ").append(Objects.requireNonNull(bible).getVerse()).append("\n");
            stringBuilder.append("Content\t: ").append(Objects.requireNonNull(bible).getContent()).append("\n");
        });

        System.out.println(stringBuilder);
    }

    @Test
    public void findBiblesByRange() {
        stringBuilder = new StringBuilder();

        // Test data set
        List<BibleRequestDto> bibleRequestDtoList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            bibleRequestDtoList.add(BibleRequestDto.builder()
                    .book(i)
                    .chapter(i)
                    .verse(i)
                    .build());
        }

        List<Bible> bibles = bibleRequestDtoList.stream().map(this::getBible).toList();
        bibles.forEach(bible -> {
            stringBuilder.append("----------------Bible----------------\n");
            stringBuilder.append("Book\t: ").append(Objects.requireNonNull(bible).getBook()).append("\n");
            stringBuilder.append("Chapter\t: ").append(Objects.requireNonNull(bible).getChapter()).append("\n");
            stringBuilder.append("Verse\t: ").append(Objects.requireNonNull(bible).getVerse()).append("\n");
            stringBuilder.append("Content\t: ").append(Objects.requireNonNull(bible).getContent()).append("\n");
        });

        System.out.println(stringBuilder);
    }

    private Bible getBible(BibleRequestDto bibleRequestDto) {
        String getBibleQuery = "select * from bible_korHRV where book = ? and chapter = ? and verse = ?";
        int getBookBySearchDto = bibleRequestDto.getBook();
        int getChapterBySearchDto = bibleRequestDto.getChapter();
        int getVerseBySearchDto = bibleRequestDto.getVerse();

        return this.jdbcTemplate.queryForObject(getBibleQuery,
                (rs, rowNum) -> new Bible(
                        rs.getInt("book"),
                        rs.getInt("chapter"),
                        rs.getInt("verse"),
                        rs.getString("content")),
                getBookBySearchDto, getChapterBySearchDto, getVerseBySearchDto);
    }
}
