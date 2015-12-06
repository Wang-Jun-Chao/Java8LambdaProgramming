package com.java.lamdba.mutablecustom;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Author: 王俊超
 * Date: 2015-12-05 14:36
 * Declaration: All Rights Reserved !!!
 */
public class AlbumSalesCollector implements Collector<AlbumSale, AlbumSalesReport,AlbumSalesReport> {
    private static final Set<Collector.Characteristics> characteristics = new HashSet<>();
    static {
        characteristics.add(Collector.Characteristics.UNORDERED);
        characteristics.add(Collector.Characteristics.IDENTITY_FINISH);
    }

    @Override
    public Supplier<AlbumSalesReport> supplier() {
        return AlbumSalesReport::new;
    }

    @Override
    public BiConsumer<AlbumSalesReport, AlbumSale> accumulator() {
        return AlbumSalesReport::acknowledgeSale;
    }

    @Override
    public BinaryOperator<AlbumSalesReport> combiner() {
        return AlbumSalesReport::merge;
    }

    @Override
    public Function<AlbumSalesReport, AlbumSalesReport> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }
}
