package com.java.lambda;

/**
 * Author: 王俊超
 * Date: 2015-12-05 08:46
 * Declaration: All Rights Reserved !!!
 */
public interface Carriage {
    // 默认方法
    default String rock() {
        return "... from side to side";
    }
}
