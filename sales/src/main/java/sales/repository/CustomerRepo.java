package sales.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import sales.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepo {

    private static String INSERT = "insert into customer (name) values (?) ";
    private static String SELECT_ALL = "select * from customer";
    private static String SELECT_NAME = "select * from customer where name = ?";
    private static String UPDATE = "update customer set name = ? where id = ?";
    private static String DELETE = "delete from customer  where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Customer customer) {
        jdbcTemplate.update(INSERT, customer.getName());
    }

    public List<Customer> getCustomers(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Customer>(){
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Customer(rs.getInt("id"), rs.getString("name"));
            }
        });
    }

    public List<Customer> getCustomersByName(String name){
        return jdbcTemplate.query(SELECT_NAME, new Object[]{"%" + name + "%"},new RowMapper<Customer>(){
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Customer(2, rs.getString("name"));
            }
        });
    }

    public Customer update(Customer customer){
        jdbcTemplate.update(UPDATE, customer.getName(),customer.getId());
        return customer;
    }

    public void delete(Integer id){
        jdbcTemplate.update(DELETE, id);
    }
}
