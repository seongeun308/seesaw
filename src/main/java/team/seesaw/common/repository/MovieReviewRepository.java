package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.MovieReview;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
}
