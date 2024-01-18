package sales.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table( name = "order")
public class Order {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "customer_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    private LocalDate localDate;

    @Column(name = "total", scale = 2, precision = 20)
    private BigDecimal total;

    public Set<OrderCommited> getOrderCommitedSet() {
        return orderCommitedSet;
    }

    public void setOrderCommitedSet(Set<OrderCommited> orderCommitedSet) {
        this.orderCommitedSet = orderCommitedSet;
    }

    @OneToMany(mappedBy = "order")
    private Set<OrderCommited> orderCommitedSet;

}
