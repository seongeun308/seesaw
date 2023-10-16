package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.MovieDirector;

@Repository
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Long> {
}
