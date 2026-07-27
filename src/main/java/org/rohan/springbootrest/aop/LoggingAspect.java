package org.rohan.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /*

    * @Before : execute advice before matched method .
    * This allows logging or performance action before method runs without modifying the target method
    * Here We Have To Specify some constraints .
    * returntype , class-name.method-name(args)
    *
    * *
    * */
    @Before("execution(* org.rohan.springbootrest.service.JobService.*(..))")
    public void methodCalled(JoinPoint jp){
        LOGGER.info("Method Called !"+jp.getSignature().getName());
    }

    /*
    * @After Runs When Method Finishes*/
    @After("execution(* org.rohan.springbootrest.service.JobService.*(..))")
    public void methodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed !"+jp.getSignature().getName());
    }

    /*
    * @AfterThrowing Runs When when the method throw an exception
    * */
    @AfterThrowing("execution(* org.rohan.springbootrest.service.JobService.*(..))")
    public void methodError(JoinPoint jp){
        LOGGER.info("Error Occured At the method Executing !"+jp.getSignature().getName());
    }

    /*
    * @AfterReturning Runs When successful execution of the method
    * */
    @AfterReturning("execution(* org.rohan.springbootrest.service.JobService.*(..))")
    public void methodSuccessful(JoinPoint jp){
        LOGGER.info("Success Fully Executed The Method"+jp.getSignature().getName());
    }
}
/*
* logies:
○ Aspect: A module that encapsulates behaviors affecting multiple
classes.
○ Join Point: A point in the execution of a program, such as method
execution or exception handling.
○ Advice: The action taken by an aspect at a particular join point (e.g.,
@Before, @After).
○ Pointcut: The expression that defines at which join points advice
should be applied.
○ Target: The object being advised by one or more aspects.
○ AOP Proxy: A proxy object created by the AOP framework.
○ Weaving: The process of linking aspects with other application types.
* */


