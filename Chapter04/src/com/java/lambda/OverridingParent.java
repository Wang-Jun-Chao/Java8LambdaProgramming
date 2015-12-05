package com.java.lambda;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:25
 * Declaration: All Rights Reserved !!!
 */
public class OverridingParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
