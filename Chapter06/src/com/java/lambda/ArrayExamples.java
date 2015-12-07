package com.java.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Author: 王俊超
 * Date: 2015-12-06 09:11
 * Declaration: All Rights Reserved !!!
 */
public class ArrayExamples {
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i ->{
                    double prefix = i == start ? 0:sums[i - n];
                    return (sums[i] - prefix)/n;
                })
                .toArray();
    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i->i);
        return values;
    }

    public static double[] imperativeInitialize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }
}
