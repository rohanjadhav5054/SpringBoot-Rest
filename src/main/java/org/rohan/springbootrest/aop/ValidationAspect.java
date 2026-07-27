package org.rohan.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* org.rohan.springbootrest.service.JobService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp,int postId) throws Throwable {
        if(postId < 0){

            LOGGER.info("Post Id Is Negative , Updating It ");
            postId = -postId;
            LOGGER.info("New Value : "+postId);

        }
        Object obj = pjp.proceed(new Object[]{postId});

        return obj;
    }


}
