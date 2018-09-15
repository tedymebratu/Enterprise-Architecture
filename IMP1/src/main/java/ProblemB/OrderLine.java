package ProblemB;

import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    public OrderLine() {
    }

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
