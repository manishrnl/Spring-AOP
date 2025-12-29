package springaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectsV2 {


    @AfterReturning(value = "getPackagePointCut()", returning = "returnedValue")
    public void afterReturningValue(JoinPoint joinPoint, Object returnedValue) {
        log.info("If a function returns something then we get this message");
        log.info("Returned value : {} ", returnedValue);
        log.info("Method signature : {} ", joinPoint.getSignature());
    }

    @AfterThrowing("getPackagePointCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("We get this message only if some Exception has occurred inside method");
        log.info("We get exception in Method  : {}", joinPoint.getSignature());
        //  log.info("Exceptions : {}", exception);
    }

    @Pointcut("execution(* springaop.services.impl.*.*(..))")
    public void getPackagePointCut() {
    }
}
