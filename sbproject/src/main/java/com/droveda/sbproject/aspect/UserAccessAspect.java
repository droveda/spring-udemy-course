package com.droveda.sbproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//configuration
@Aspect
@Configuration
public class UserAccessAspect {

    private static final Logger LOG = LoggerFactory.getLogger(UserAccessAspect.class);

    //weaving & weaver
    //what kind of method calls I would like to intercept
    //execution(* PACKAGE.*.*(..))
//    @Before("execution(* com.droveda.sbproject.service.*.*(..))")
//    @Before("execution(* com.droveda.sbproject.dao.*.*(..))")
//    @Before("execution(* com.droveda.sbproject..*.*(..))")
    @Before("com.droveda.sbproject.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        //advice
        //for what is it applicable?
        //example check for the user access...
        LOG.info("Intercepted method calls - {}", joinPoint);
    }

}
