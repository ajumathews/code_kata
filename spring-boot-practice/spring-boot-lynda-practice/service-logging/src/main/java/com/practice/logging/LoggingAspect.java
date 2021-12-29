package com.practice.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(Timed)")
    public void executeLogging(){}

    @Around("executeLogging()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Before "+joinPoint.getSignature().getName() );
        Object returnValue = joinPoint.proceed();
        System.out.println("After "+joinPoint.getSignature().getName() );
        return returnValue;
    }
}
