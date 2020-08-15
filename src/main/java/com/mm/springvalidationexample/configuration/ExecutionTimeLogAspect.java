package com.mm.springvalidationexample.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class ExecutionTimeLogAspect {

    @Around("@annotation(ExecutionTimeLog)")
    public Object logTimeTaken(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        System.out.println("Time Taken to run method: " + stopWatch.getTotalTimeMillis()
                + " Class Name:" + joinPoint.getSignature().getDeclaringTypeName()
                + " Method Name:" + joinPoint.getSignature().getName()
                + " Arguments: " + joinPoint.getArgs().toString());
        return proceed;
    }
}
