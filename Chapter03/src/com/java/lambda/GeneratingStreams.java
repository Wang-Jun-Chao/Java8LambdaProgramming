package com.java.lambda;

import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015/12/3 16:37
 * All Rights Reserved !!!
 */
public class GeneratingStreams {


    static void generate() {
        Stream.generate(() -> "hello world").limit(3).forEach(System.out::println);
    }

    static void iterate() {
        Stream.iterate(0, x -> x + 1).limit(5).forEach(System.out::println);
    }

    public static void main(String[] args) {
        generate();
        iterate();
    }
}
