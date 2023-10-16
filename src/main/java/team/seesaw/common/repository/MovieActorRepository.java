package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.MovieActor;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
}
