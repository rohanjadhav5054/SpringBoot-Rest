package org.rohan.springbootrest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public void methodCalled(){
        LOGGER.info("Method Called !");
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

