package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.classes.Order;

@Repository
public interface UserRepository extends JpaRepository<Order,Integer> {

}
