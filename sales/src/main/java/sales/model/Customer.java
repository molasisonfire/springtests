package sales.model;

import jakarta.persistence.*;

@Entity
@Table( name = "Customer")
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }
    public Customer() {
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
        return "Customer{id = "+ getId() +", name = "+getName() +"}";
    }
}
