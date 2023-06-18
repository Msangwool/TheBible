package com.example.thebible.repository;

import com.example.thebible.core.entity.Bible;
import com.example.thebible.dto.BibleChapterRequestDto;
import com.example.thebible.dto.BibleRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JpaBibleRepository implements BibleRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Bible findBible(BibleRequestDto bibleRequestDto) {
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

    public List<Bible> findBiblesByChapter(BibleChapterRequestDto bibleChapterRequestDto) {
        String getBibleQuery = "select * from bible_korHRV where book = ? and chapter = ?";
        int getBookBySearchDto = bibleChapterRequestDto.getBook();
        int getChapterBySearchDto = bibleChapterRequestDto.getChapter();

        return this.jdbcTemplate.query(
                getBibleQuery,
                (rs, rowNum) -> new Bible(
                        rs.getInt("book"),
                        rs.getInt("chapter"),
                        rs.getInt("verse"),
                        rs.getString("content")
                ),
                getBookBySearchDto, getChapterBySearchDto);
    }

    public List<Bible> findBiblesByRange(List<BibleRequestDto> bibleRequestDtoList) {
        return bibleRequestDtoList.stream().map(this::findBible).toList();
    }
}
