import cs544.hpa2.Car;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AppCar {

    private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cs544.hpa2" );
    private  static  EntityManager entitymanager = emfactory.createEntityManager( );



    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception
    {
        // A SessionFactory is set up once for an application!

        entitymanager.getTransaction( ).begin( );


    }

    protected static void tearDown() throws Exception {



        entitymanager.close( );
    }

    public static void main(String[] args) throws Exception {
        setUp();
        // Create new instance of cs544.hpa1.Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        entitymanager.persist( car1 );
        // Create new instance of cs544.hpa1.Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        entitymanager.persist( car2 );
        entitymanager.getTransaction( ).commit( );




        // retieve all cars
        @SuppressWarnings("unchecked")
        List<Car> carList = entitymanager.createQuery("FROM Car ").getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }



        // Close the SessionFactory (best practice)
        tearDown();
    }
}

