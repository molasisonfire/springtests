package sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.model.OrderCommited;


public interface OrderCommitedRepo extends JpaRepository<OrderCommited,Integer> {
}
