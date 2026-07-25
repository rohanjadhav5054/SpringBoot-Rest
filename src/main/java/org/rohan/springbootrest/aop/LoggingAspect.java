package org.rohan.springbootrest.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public void methodCalled(){
        LOGGER.info("Method Called !");
    }
}
