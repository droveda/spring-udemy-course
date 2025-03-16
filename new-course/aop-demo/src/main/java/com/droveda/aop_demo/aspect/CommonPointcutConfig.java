package com.droveda.aop_demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.droveda.aop_demo.service.*.*.*(..))")
    public void servicePackageConfig() {
    }

    @Pointcut("execution(* com.droveda.aop_demo.service.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.droveda.aop_demo.service.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("bean(*Service*)") //it will intercept based on the name of the bean
    public void dataPackageConfigUsingBean() {}


    @Pointcut("@annotation(com.droveda.aop_demo.aspect.annotation.TrackTime)")
    public void trackTimeAnnotation() {
    }

}
