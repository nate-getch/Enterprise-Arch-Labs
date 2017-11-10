package cs544.exercise13_1.aop.basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cs544.exercise13_1.aop.basic.EmailSender;

import java.util.Date;

@Component
@Aspect
public class EmailAdvice {
    @After("execution(* cs544.exercise13_1.aop.basic.EmailSender.sendEmail(..))")
    public void traceAfterMethod(JoinPoint joinPoint){
        System.out.println(new Date() + " method = " + joinPoint.getSignature().getName());
        System.out.println("Email: "+ joinPoint.getArgs()[0]);
        System.out.println("Message: "+ joinPoint.getArgs()[1]);
        EmailSender emailSender = (EmailSender)joinPoint.getTarget();
        System.out.println("outgoing mail server " + emailSender.getOutgoingMailServer());
    }
}
