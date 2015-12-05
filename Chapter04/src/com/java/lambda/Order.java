package com.java.lambda;

import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015-12-05 08:59
 * Declaration: All Rights Reserved !!!
 */
public abstract class Order {
    protected final List<Album> albums;

    public Order(List<Album> albums) {
        this.albums = albums;
    }

    /**
     * 计算所有唱片中的所有曲目的演奏的总时间
     *
     * @return 所有唱片中的所有曲目的演奏的总时间
     */
    public abstract long countRunningTime();

    /**
     * 计算所有唱片中的所有作者
     *
     * @return 所有唱片中的所有作者
     */
    public abstract long countMusicians();

    /**
     * 计算所有唱片中的所有曲目的数目
     *
     * @return 所有唱片中的所有曲目的数目
     */
    public abstract long countTracks();
}
