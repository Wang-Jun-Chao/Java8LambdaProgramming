package com.java.lambda;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:33
 * Declaration: All Rights Reserved !!!
 */
public class OrderDomain extends Order {
    public OrderDomain(List<Album> albums) {
        super(albums);
    }
    public long countFeature(ToLongFunction<Album> function) {
        return albums.stream().mapToLong(function).sum();
    }
    @Override
    public long countRunningTime() {
        return countFeature(albums->albums.getTracks().mapToLong(Track::getLength).sum());
    }

    @Override
    public long countMusicians() {
        return countFeature(album->album.getMusicians().count());
    }

    @Override
    public long countTracks() {
        return countFeature(album->album.getTracks().count());
    }
}
