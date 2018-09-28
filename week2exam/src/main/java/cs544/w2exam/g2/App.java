package cs544.w2exam.g2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=
                new ClassPathXmlApplicationContext("springconfig.out.xml");
        System.out.println("Testing Spring");
        ClassA a=context.getBean("b",ClassB.class);
        ((ClassB) a).setText("Test");
        context.close();
    }
}
