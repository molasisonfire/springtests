package sales.model;

public class Customer {
    private Integer id;

    public Customer(int i, String name) {
        this.name = name;
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

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
