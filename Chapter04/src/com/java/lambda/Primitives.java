package com.java.lambda;

import java.util.IntSummaryStatistics;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:27
 * Declaration: All Rights Reserved !!!
 */
public class Primitives {
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTracks()
                .mapToInt(Track::getLength)
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
}
