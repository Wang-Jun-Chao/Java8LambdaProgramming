package com.java.lamdba.mutablecustom;

/**
 * Author: 王俊超
 * Date: 2015-12-05 14:31
 * Declaration: All Rights Reserved !!!
 */
public class AlbumSalesReport {
    public AlbumSalesReport() {
    }

    public AlbumSalesReport(AlbumSale album) {
        this();
        acknowledgeSale(album);
    }

    public void acknowledgeSale(AlbumSale album) {
    }

    public AlbumSalesReport merge(AlbumSalesReport right) {
        return null;
    }
}
