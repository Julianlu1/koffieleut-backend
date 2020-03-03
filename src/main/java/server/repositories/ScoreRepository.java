package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {
    Score findByUserId(int userId);
}
