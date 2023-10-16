package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @Builder
    public MovieReview(Movie movie, Review review) {
        this.movie = movie;
        this.review = review;
    }
}
