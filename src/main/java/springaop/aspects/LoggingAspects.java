package springaop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspects {


    //  @Before("execution(* trackPackage(..))")
//    @Before("execution(* springaop.services.impl.ShipmentServiceImpl.orderPackage(..))")
    @Before("execution(* springaop.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before orderPackage called from LoggingAspects kind : {}",
                joinPoint.getKind());
        log.info("Before orderPackage called from LoggingAspects Signature : {}",
                joinPoint.getSignature());
    }


    //    @Before("within(springaop.services.impl.*)")
    @Before("within(springaop..*) || transactionalPointCut()")
    public void beforeServiceImplCall() {
        log.info("Service Impl called");
    }

    @Before("transactionalPointCut()")
    public void beforeTransactionalAnnotation() {
        log.info("Transactional Annotation is used");
    }


    //Creating a custom pointCut that can be reused again which is stored inside a variable
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalPointCut() {
    }

}
