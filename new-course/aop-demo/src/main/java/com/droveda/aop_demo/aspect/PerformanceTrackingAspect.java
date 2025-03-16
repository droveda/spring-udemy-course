package com.droveda.aop_demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTrackingAspect.class);

    //    @Around("execution(* com.droveda.aop_demo.service.business.*.*(..))")
    //@Around("com.droveda.aop_demo.aspect.CommonPointcutConfig.businessPackageConfig()")
    @Around("com.droveda.aop_demo.aspect.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        long duration = end - start;
        log.info("Around Aspect - {} Method executed in {} milliseconds", "Method Name", duration);

        return returnValue;
    }

}
