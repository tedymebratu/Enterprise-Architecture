package cs544.cxm1;

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

            Doctor doc=new Doctor("Eye Doctor","Theodros","Mebratu");

           // session.persist(doc);

            Patient patient=new Patient("John","1000 N","52557","Fairfield");

           // session.persist(patient);

            Payment payment=new Payment("2018-09-03",5000);

           // session.persist(payment);

            Appointment appointment=new Appointment();
            appointment.setAppdate("15/05/08");
            appointment.setPayment(payment);
            appointment.setDoctor(doc);
            appointment.setPatient(patient);







            session.persist(appointment);


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
