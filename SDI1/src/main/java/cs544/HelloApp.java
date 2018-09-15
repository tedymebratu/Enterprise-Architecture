package cs544;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {

        System.out.println(1);

        ConfigurableApplicationContext context = new
                ClassPathXmlApplicationContext("springconfig.xml");
        System.out.println(2);

        Greeting greetingService = context.getBean("greetingService", Greeting.class);
        System.out.println(3);

        Greeting greetingService1 = context.getBean("greetingService", Greeting.class);
        System.out.println(4);
       System.out.println("greetingService");
       greetingService.sayHello();

        System.out.println("greetingService1");
        greetingService1.sayHello();

        context.close();
        System.out.println(5);
    }


}