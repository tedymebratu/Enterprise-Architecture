package cs544.w2exam.g2;

import cs544.w2exam.g2.ClassA;

public class ClassB extends ClassA {
    private ClassC c;

    public ClassB(ClassC c) {
        System.out.println("Class B Constructor");
        this.c=c;
    }

    public void setText(String text){
        System.out.println("Setting text in B");
        c.setText(text);
        super.getText(text);
    }
    public void setC(ClassC c) {this.c=c;}
}
