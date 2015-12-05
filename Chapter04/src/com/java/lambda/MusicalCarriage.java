package com.java.lambda;

/**
 * Author: 王俊超
 * Date: 2015-12-05 08:58
 * Declaration: All Rights Reserved !!!
 */
public class MusicalCarriage implements Carriage, Jukebox {
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}
