package com.mm.springvalidationexample.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.Serializable;

@Component
@Aspect
public class ExecutionTimeLogAspect {

    @Autowired
    private ObjectMapper mapper;

    @Around("@annotation(ExecutionTimeLog)")
    public Object logTimeTaken(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        String input = "";
        for (Object obj: joinPoint.getArgs()) {
            if(obj instanceof Serializable){
                input = mapper.writeValueAsString(obj);
            }
        }

        System.out.println("Time Taken to run method: " + stopWatch.getTotalTimeMillis()
                + " Class Name:" + joinPoint.getSignature().getDeclaringTypeName()
                + " Method Name:" + joinPoint.getSignature().getName()
                + " Arguments: " + input);
        return proceed;
    }
}
