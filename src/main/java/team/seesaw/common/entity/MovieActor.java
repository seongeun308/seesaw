package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Builder
    public MovieActor(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }
}
