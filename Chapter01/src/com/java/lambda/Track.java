package com.java.lambda;

/**
 * 曲目类
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 08:20
 */
public class Track {
    // 曲目的名字
    private final String name;
    // 曲目的长度
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
