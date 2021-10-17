package com.droveda.sbproject.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.droveda.sbproject.dao.*.*(..))")
    public void dataLayerExecution() {
    }

    @Pointcut("execution(* com.droveda.sbproject.service.*.*(..))")
    public void serviceLayerExecution() {
    }

    @Pointcut("@annotation(com.droveda.sbproject.aspect.TrackTime)")
    public void trackTimeAnnotation() {
    }

}
