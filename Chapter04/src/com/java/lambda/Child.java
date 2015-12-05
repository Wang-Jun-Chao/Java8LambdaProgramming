package com.java.lambda;

/**
 * Author: 王俊超
 * Date: 2015-12-05 08:52
 * Declaration: All Rights Reserved !!!
 */
public interface Child extends Parent{
    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}
