package com.java.lambda.observer;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:45
 * All Rights Reserved !!!
 */
public class Nasa implements LandingObserver{
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }
}
