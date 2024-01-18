package sales.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_commited")
public class OrderCommited {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn( name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn( name = "product_id")
    private  Product product;
    private Integer quantity;
}
