package com.java.lambda;

import java.util.function.Supplier;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:37
 * Declaration: All Rights Reserved !!!
 */
public class Logger {
    private boolean debug = true;

    public boolean isDebugEnabled() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            System.out.println(message);
        }
    }


    public void example() {
        Logger logger = new Logger();
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    private String expensiveOperation() {
        return "";
    }

    public void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }

    public void exampleWithLambda() {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
    }

}
