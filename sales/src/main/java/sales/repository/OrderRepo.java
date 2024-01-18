package sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.model.Order;


public interface OrderRepo extends JpaRepository<Order,Integer> {
}
