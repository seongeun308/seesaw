package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.MovieGenre;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {


}
