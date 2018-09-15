package cs544.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
public class EmailSentLog {


    @After("execution(* EmailSender.sendEmail(..))")
    public void afterMethod(JoinPoint joinpoint) {
        EmailSender emailSender=new EmailSender();
        System.out.println(new Date() + " Method= " +joinpoint.getSignature().getName()
         + "  address= "+ joinpoint.getArgs()[0] + "\nmessage= "+ joinpoint.getArgs()[1]
        + "\noutgoing mail server= "+emailSender.outgoingMailServer);
    }






}
