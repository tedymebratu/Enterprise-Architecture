package ProblemA;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Laptop_Employee")
    private Employee employee;

    public Laptop() {
    }

    public Laptop(String brand, String type, Employee employee) {
        this.brand = brand;
        this.type = type;
        this.employee = employee;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
