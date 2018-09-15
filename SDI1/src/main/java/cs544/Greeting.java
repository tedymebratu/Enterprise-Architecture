package cs544;

public class Greeting implements iService{

    private String greeting;

    public Greeting() {
        System.out.println("Object created");
    }
    public Greeting(String greeting){
        this.greeting=greeting;
    }

    public void sayHello(){
        System.out.println(greeting);
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void init() {
        System.out.println("Calling init method");
    }

    public void cleanup() {
        System.out.println("Calling cleanUp method");
    }
}
