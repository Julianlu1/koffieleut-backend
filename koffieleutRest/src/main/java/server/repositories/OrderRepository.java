package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
