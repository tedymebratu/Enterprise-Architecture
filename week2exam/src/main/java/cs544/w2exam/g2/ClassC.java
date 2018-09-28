package cs544.w2exam.g2;

public class ClassC {
    private String text;

    public ClassC() {
        System.out.println("Class C Constructor");
    }

    public void setText(String text) {
        System.out.println("Setting text in C");
        this.text=text;
    }
}
