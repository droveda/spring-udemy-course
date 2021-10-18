package com.droveda.sbproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalcAspect {

    private static final Logger LOG = LoggerFactory.getLogger(MethodExecutionCalcAspect.class);

    //@Around("execution(* com.droveda.sbproject.service.*.*(..))")
    @Around("com.droveda.sbproject.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //start time
        //allow execution
        //end time
        //difference end - start

        long start = System.currentTimeMillis();
        Object ret = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - start;
        LOG.info("Time taken by this {} is {}", proceedingJoinPoint, timeTaken);
        return ret;
    }


}
