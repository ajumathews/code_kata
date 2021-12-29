package orderAppAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){ }

    @Pointcut("target(orderAppAspect.OrderServiceImpl)")
    public void executeCounter(){ }

    @Pointcut("execution(String orderAppAspect.OrderServiceImpl.helloWorld())")
    public void executeCounterHelloWorld(){ }

    @Before("executeCounter()")
    public void beforeAdviceExecuteCounter(JoinPoint joinPoint) {
        System.out.println("Invocation count "+joinPoint.getSignature().getName()+" called");
    }


    @Before("executeCounterHelloWorld()")
    public void beforeAdviceExecuteCounterHelloWorld(JoinPoint joinPoint) {
        System.out.println("Invocation count Helloworld "+joinPoint.getSignature().getName()+" called");
    }


    @Before("executeLogging()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before "+joinPoint.getSignature().getName()+" called");
    }

    @After("executeLogging()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After "+joinPoint.getSignature().getName()+" called");

    }

    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void afterReturnAdvice(JoinPoint joinPoint,Object returnValue){
        System.out.println("After Returning "+joinPoint.getSignature().getName()+" called : " + returnValue);
    }


    @Around("executeLogging()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Before:"+ joinPoint.getSignature().getName());
        Object returnValue=joinPoint.proceed();
        System.out.println("After around:" + returnValue);
        return returnValue;


    }

}
