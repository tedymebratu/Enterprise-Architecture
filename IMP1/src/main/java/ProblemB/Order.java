package ProblemB;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Order_tbl")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate datedata;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines=new ArrayList();

    public Order() {
    }

    public Order(LocalDate datedata, Customer customer) {
        this.datedata = datedata;
        this.customer = customer;
    }

    public LocalDate getDate() {
        return datedata;
    }

    public void setDate(LocalDate datedata) {
        this.datedata = datedata;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addOrderLine(OrderLine orderLine){
        orderLines.add(orderLine);
    }
    public void removeOrderLine(OrderLine orderLine){
        orderLines.remove(orderLine);
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
