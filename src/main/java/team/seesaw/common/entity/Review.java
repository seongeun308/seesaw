package team.seesaw.common.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @ToString
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int rate;
    @Column
    private String comment;
    @OneToMany(mappedBy = "review")
    private List<MovieReview> movieReviewList;
}
