package cs544.imp1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.time.LocalDate;
import java.util.List;

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
            Customer cust1=new Customer("Theodros","Mebratu");
            Customer cust2=new Customer("Francisco","Juan");

            // Create new instance of Car and set values in it

            LocalDate currentDate = LocalDate.now();

            Order order1=new Order(currentDate,cust1);
            Order order2=new Order(currentDate,cust2);


            Product prod1=new Product("Mobile","Latest Apple");
            Product prod2=new Product("TV","Latest TV");
            Product prod3=new Product("Bike","Latest Bike");

            order1.addOrderLine(new OrderLine(prod1,5));
            order1.addOrderLine(new OrderLine(prod2,10));
            order1.addOrderLine(new OrderLine(prod3,15));
            order2.addOrderLine(new OrderLine(prod1,20));
            order2.addOrderLine(new OrderLine(prod2,7));
            order2.addOrderLine(new OrderLine(prod3,5));

            // save the order
            session.persist(order1);
            session.persist(order2);



            session.getTransaction().commit();
        }

        try (Session session  = sessionFactory.openSession()) {
            session.beginTransaction();

            // retieve all cars
           // @SuppressWarnings("unchecked")
           /* List<Order> orders = session.createQuery("from Order ").list();
            for (Order order : orders) {
                System.out.println("Date= " + order.getDate() + ", Customer= "
                        + order.getCustomer().getFirstname() );
            }*/
            session.getTransaction().commit();
        }

        // Close the SessionFactory (best practice)
        tearDown();
    }
}

