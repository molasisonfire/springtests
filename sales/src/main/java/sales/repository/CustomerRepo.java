package sales.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sales.model.Customer;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomers(){
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomersByName(String name){
        String jpql = " select c from Customer c where c.name = like : ";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer){
        entityManager.merge(customer);
        return customer;
    }

    @Transactional
    public void delete(Integer id){
        entityManager.remove(entityManager.find(Customer.class,id));
    }
}
