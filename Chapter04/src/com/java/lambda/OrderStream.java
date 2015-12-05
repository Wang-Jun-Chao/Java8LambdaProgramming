package com.java.lambda;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:10
 * Declaration: All Rights Reserved !!!
 */
public class OrderStream extends Order {
    public OrderStream(List<Album> albums) {
        super(albums);
    }

    @Override
    public long countRunningTime() {
        return albums.stream().mapToLong(album -> album.getTracks().mapToLong(Track::getLength).sum()).sum();
    }

    @Override
    public long countMusicians() {
        return albums.stream().mapToLong(album -> album.getMusicians().count()).sum();
    }

    @Override
    public long countTracks() {
        return albums.stream().mapToLong(album -> album.getTracks().count()).sum();
    }
}
