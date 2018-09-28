package cs544.w2exam.g2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {

        ClassA a=new ClassB(new ClassC());
        System.out.println("Testing Spring");
        //ClassC c=new ClassC();

    }
}
