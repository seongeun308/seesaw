package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.Review;

import javax.persistence.PostPersist;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
