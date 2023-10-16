package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.List;
import java.util.Locale;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=100000)
    private byte[] poster;
    @Column
    private String title;
    @Column
    private String country;
    @Column
    private int runningTime;
    @Column
    private String releaseDate;
    @Column
    private String ageRate;

    @OneToMany(mappedBy = "movie")
    private List<MovieDirector> movieDirectorList;
    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenreList;
    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActorList;
    @OneToMany(mappedBy = "movie")
    private List<MovieReview> movieReviewList;

    @Builder
    public Movie(byte[] poster, String title, String country, int runningTime, String releaseDate, String ageRate) {
        this.poster = poster;
        this.title = title;
        this.country = country;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.ageRate = ageRate;
    }
}
