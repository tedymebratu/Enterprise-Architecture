package cs544.w2exam.g2;

public abstract class ClassA {
    private String text;

    public ClassA() {
        System.out.println("Class A Constructor");
    }
    public void getText(String text){
        System.out.println("Setting text in A");
        this.text=text;
    }
    public void start() {System.out.println("Class A start method");}
    public void stop() {System.out.println("Class A stop method");}
}
