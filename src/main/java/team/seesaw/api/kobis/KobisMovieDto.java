package team.seesaw.api.kobis;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

@Getter @ToString
public class KobisMovieDto {

    private Long movieCd;
    private String movieNm;
    private String movieNmEn;
    private String prdtYear;
    private String repNationNm;
    private String genreAlt;
    private JsonNode directors;
    private String showTm;
    private JsonNode actors;
    private String watchGradeNm;

    @Builder
    public KobisMovieDto(Long movieCd, String movieNm, String movieNmEn, String prdtYear,
                         String repNationNm, String genreAlt, JsonNode directors,
                         String showTm, JsonNode actors, String watchGradeNm) {
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.movieNmEn = movieNmEn;
        this.prdtYear = prdtYear;
        this.repNationNm = repNationNm;
        this.genreAlt = genreAlt;
        this.directors = directors;
        this.showTm = showTm;
        this.actors = actors;
        this.watchGradeNm = watchGradeNm;
    }

}
