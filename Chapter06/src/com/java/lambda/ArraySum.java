package com.java.lambda;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author: 王俊超
 * Date: 2015-12-06 09:29
 * Declaration: All Rights Reserved !!!
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class ArraySum {
    public List<Album> albums;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {".*ArraySum.*", "-wi", "5", "-i", "5"};
        Main.main(args);
    }

    @Setup
    public void initAlbums() {
        int n = Integer.getInteger("arraysum.size", 1000);
        albums = IntStream.range(0, n)
                .mapToObj(i -> SampleData.aLoveSupreme.copy())
                .collect(Collectors.toList());
    }

    @GenerateMicroBenchmark
    public int serialArraySum() {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    @GenerateMicroBenchmark
    public int parallelArraySum() {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
}
