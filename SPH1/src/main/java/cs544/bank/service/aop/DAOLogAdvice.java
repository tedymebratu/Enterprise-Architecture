package cs544.bank.service.aop;

import cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class DAOLogAdvice {
    private ILogger logger;

    @After("execution(* cs544.bank.dao.*.*(..))")
    public void afterMethod(JoinPoint joinpoint) {

        logger.log("****DAOLog: "+ joinpoint.getSignature().toString()+ "1.0.0");
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger;
    }
}
