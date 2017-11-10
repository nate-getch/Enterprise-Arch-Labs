package cs544.exercise13_1.aop.basic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class DurationCalculator {

    @Around("execution(* cs544.exercise13_1.aop.basic.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println("Time to execute save " + totaltime + " ms");
        return retVal;
    }

}
