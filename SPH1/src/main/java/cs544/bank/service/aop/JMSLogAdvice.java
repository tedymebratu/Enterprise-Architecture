package cs544.bank.service.aop;

import cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class JMSLogAdvice {

     private ILogger logger;

     @After("execution(* cs544.bank.jms.*.*(..))")
     public void jmsLog(JoinPoint joinPoint){
         logger.log("***JMSLog: "+  joinPoint.getSignature().getName() +" 1.0.0");
     }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }
}
