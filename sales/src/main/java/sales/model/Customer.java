package sales.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "Customer")
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    private String name;

    public List<Order> getOrder() {
        return order;
    }

    public void setorder(List<Order> order) {
        this.order = order;
    }

    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    public Customer(String name) {
        this.name = name;
    }
    public Customer() {
    }

    public Customer(Integer id , String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
