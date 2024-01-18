package sales.model;

import java.math.BigDecimal;

public class Product {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String description;
    private BigDecimal price;
}
