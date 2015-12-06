package com.java.lamdba.mutablecustom;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015-12-05 14:32
 * Declaration: All Rights Reserved !!!
 */
public class CollectorExpansions {
    public static Collector<AlbumSale, ?, AlbumSalesReport> reportingAlbumSales(){
        return Collectors.reducing(
                new AlbumSalesReport(),
                AlbumSalesReport::new,
                AlbumSalesReport::merge);
    }
}
