package com.java.lambda;

import java.util.stream.Stream;

/**
 * 播放类
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 08:24
 */
public interface Performance {
    public String getName();
    public Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}
