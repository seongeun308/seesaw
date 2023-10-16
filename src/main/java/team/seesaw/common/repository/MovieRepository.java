package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
