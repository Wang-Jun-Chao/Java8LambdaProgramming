package com.java.lambda;

/**
 * Author: 王俊超
 * Date: 2015-12-05 08:56
 * Declaration: All Rights Reserved !!!
 */
public class ParentImpl implements Parent {
    private String body;
    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }
}
