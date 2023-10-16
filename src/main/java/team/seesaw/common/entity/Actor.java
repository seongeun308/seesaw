package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Actor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String actorNm;
    @Column
    private String castNm;
    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActorList;

    @Builder
    public Actor(String actorNm, String castNm) {
        this.actorNm = actorNm;
        this.castNm = castNm;
    }
}
