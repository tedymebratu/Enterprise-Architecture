package ProblemA;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) throws Exception {
        setUp();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            //Create an owner
            Employee emp1=new Employee("Theodros","Mebratu");
            Employee emp2=new Employee("Abe","Kebe");
            Employee emp3=new Employee("Hana","Debe");
            Employee emp4=new Employee("Sara","Lema");
            Employee emp5=new Employee("Ayu","Reta");

            // Create new instance of Car and set values in it
            Laptop laptop1 = new Laptop("HP","Latest",emp1);
            Laptop laptop3 = new Laptop("Toshiba","Corei9",emp1);
            Laptop laptop2 = new Laptop("Apple","Corei8",emp2);
            Laptop laptop4 = new Laptop("Mac","Corei10",emp3);

            // save the car
            emp2.addLaptop(laptop3);
            emp3.addLaptop(laptop1);
            emp4.addLaptop(laptop2);
            emp2.addLaptop(laptop4);


            // Create new instance of Car and set values in it

            // save the car
            session.persist(laptop1);
            session.persist(laptop2);
            session.persist(laptop3);
            session.persist(laptop4);

            session.getTransaction().commit();
        }

        try (Session session  = sessionFactory.openSession()) {
            session.beginTransaction();

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<Laptop> carList = session.createQuery("from Laptop ").list();
            for (Laptop laptop : carList) {
                System.out.println("brand= " + laptop.getBrand() + ", year= "
                        + laptop.getBrand() + ", price= " + laptop.getType() + " , Owner "+ laptop.getEmployee().getFirstname());
            }
            session.getTransaction().commit();
        }

        // Close the SessionFactory (best practice)
        tearDown();
    }
}


