package com.java.lamdba.mutablecustom;

import com.java.lambda.Album;

/**
 * Author: 王俊超
 * Date: 2015-12-05 14:30
 * Declaration: All Rights Reserved !!!
 */
public final class AlbumSale {
    private final Album album;
    private final Customer customer;
    private final long price;

    public AlbumSale(Album album, Customer customer, long price) {
        this.album = album;
        this.customer = customer;
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getPrice() {
        return price;
    }
}
