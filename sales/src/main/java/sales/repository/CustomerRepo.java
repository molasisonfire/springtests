package sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sales.model.Customer;

import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Query(value= " select * from customer c where c.name like '%:name%' ", nativeQuery = true)
    List<Customer> findCustomersByName(@Param("name") String name);

    @Query( " select c from Customer c left join fetch c.order where c.id = :id ",)
    Customer findCustomerFetchOrder( @Param("id") Integer id );
}
