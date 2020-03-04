package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

}