package team.seesaw.common.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Director {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "director")
    private List<MovieDirector> movieDirectorList;

    @Builder
    public Director(String name) {
        this.name = name;
    }
}
