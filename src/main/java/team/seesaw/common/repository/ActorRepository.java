package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
