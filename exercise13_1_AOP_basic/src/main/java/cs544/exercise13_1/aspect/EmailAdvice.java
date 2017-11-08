package cs544.exercise13_1.aspect;

import cs544.exercise13_1.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class EmailAdvice {
    @After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..))")
    public void traceAfterMethod(JoinPoint joinPoint){
        System.out.println(new Date() + " method = " + joinPoint.getSignature().getName());
        System.out.println("Email: "+ joinPoint.getArgs()[0]);
        System.out.println("Message: "+ joinPoint.getArgs()[1]);
        EmailSender emailSender = (EmailSender)joinPoint.getTarget();
        System.out.println("outgoing mail server " + emailSender.getOutgoingMailServer());
    }
}
