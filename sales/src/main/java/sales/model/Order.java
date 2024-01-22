package sales.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Order {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private Customer customer;
    private LocalDate localDate;
    private BigDecimal total;
}
