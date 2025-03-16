package com.droveda.aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    //Pointcut - when?
//    @Before("* PACKAGE.*.*(..)")
    @Before("com.droveda.aop_demo.aspect.CommonPointcutConfig.servicePackageConfig()")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        log.info("Before Aspect - Method is called - {} - {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.droveda.aop_demo.service.business.*.*(..))")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        log.info("After Aspect - Method is called - {} - {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "execution(* com.droveda.aop_demo.service.business.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("After Aspect Throwing - Method is called - {} - {} - {}",
                joinPoint,
                joinPoint.getArgs(),
                exception.getLocalizedMessage());
    }

    @AfterReturning(
            pointcut = "execution(* com.droveda.aop_demo.service.business.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
        log.info("After Aspect Returning - Method is called - {} - {} - {}", joinPoint, joinPoint.getArgs(), resultValue);
    }

}
