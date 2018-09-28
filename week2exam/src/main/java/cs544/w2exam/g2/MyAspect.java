package cs544.w2exam.g2;

import cs544.w2exam.g2.ClassC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    private ClassC classC;

    public MyAspect() {System.out.println("MyAspect Constructor");}

    @Before("execution(* cs544.*.*(..))")
    public void traceAdvice(JoinPoint jp) {
        System.out.println("Before "+ jp.getSignature().getName());
    }
    public void setClassC(ClassC classC){this.classC=classC;}
}

