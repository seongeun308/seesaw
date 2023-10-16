package team.seesaw.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.seesaw.common.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
