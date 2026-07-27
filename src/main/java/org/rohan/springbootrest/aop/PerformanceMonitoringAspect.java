package org.rohan.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* org.rohan.springbootrest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long endTime = System.currentTimeMillis();

        LOGGER.info("Time Taken To Monitoring  By This Method  : "+pjp.getSignature().getName() +" Is "+(endTime - startTime)+" ms ");

        return obj;
    }

}
