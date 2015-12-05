package com.java.lambda;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-12-05 09:02
 * Declaration: All Rights Reserved !!!
 */
public class OrderImperative extends Order {
    public OrderImperative(List<Album> albums) {
        super(albums);
    }

    /**
     * 计算所有唱片中的所有曲目的演奏的总时间
     *
     * @return long 所有唱片中的所有曲目的演奏的总时间
     */
    @Override
    public long countRunningTime() {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }

    /**
     * 计算所有唱片中的所有作者
     *
     * @return 所有唱片中的所有作者
     */
    @Override
    public long countMusicians() {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    /**
     * 计算所有唱片中的所有曲目的数目
     *
     * @return 所有唱片中的所有曲目的数目
     */
    @Override
    public long countTracks() {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }
}
