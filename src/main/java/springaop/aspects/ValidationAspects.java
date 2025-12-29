package springaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ValidationAspects {

    @Around("getPackagePointCut()")
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object args[] = proceedingJoinPoint.getArgs();

        Long orderId = (Long) args[0];
        if (orderId > 0)
            return proceedingJoinPoint.proceed();
        return "Can not call with Negative ID";

    }

    @Around("getPackagePointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        Long diff = endTime - startTime;
        log.info("Time taken to finish function {}", diff);
        return returnedValue;
    }


    @Pointcut("execution(* springaop.services.impl.*.*(..))")
    public void getPackagePointCut() {
    }
}
