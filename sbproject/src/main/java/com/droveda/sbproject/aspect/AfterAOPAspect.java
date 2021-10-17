package com.droveda.sbproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAOPAspect {

    private static final Logger LOG = LoggerFactory.getLogger(AfterAOPAspect.class);

    @AfterReturning(
            value = "execution(* com.droveda.sbproject.service.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        LOG.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "execution(* com.droveda.sbproject.service.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Object exception) {
        LOG.info("{} throw exception {}", joinPoint, exception);
    }

    @After(
            value = "execution(* com.droveda.sbproject.service.*.*(..))"
    )
    public void after(JoinPoint joinPoint) {
        LOG.info("after execution of {}", joinPoint);
    }


}
