package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieDirector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @Builder
    public MovieDirector(Movie movie, Director director) {
        this.movie = movie;
        this.director = director;
    }
}
