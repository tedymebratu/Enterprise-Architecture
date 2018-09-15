package ProblemA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "employee")
    private List<Laptop> laptopList=new ArrayList();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void addLaptop(Laptop laptop) {
        laptopList.add(laptop);
    }

    public void removeLaptop(Laptop laptop) {
        laptopList.remove(laptop);
    }
}
