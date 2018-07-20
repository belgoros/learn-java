package com.sca.learningtests;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;

/**
 * Created by Serguei on 20/10/2017.
 */
public class Log4JTest {
    @Test
    public void testLogCreate() {
        Logger logger = Logger.getLogger("MyLogger");
        logger.removeAllAppenders();
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%p %t %m%n"),
                ConsoleAppender.SYSTEM_OUT));
        logger.info("hello");
    }
}
