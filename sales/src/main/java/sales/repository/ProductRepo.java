package sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
