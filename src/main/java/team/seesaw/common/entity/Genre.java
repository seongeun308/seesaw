package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String genre;
    @OneToMany(mappedBy = "genre")
    private List<MovieGenre> movieGenreList;

    @Builder
    public Genre(String genre) {
        this.genre = genre;
    }
}
