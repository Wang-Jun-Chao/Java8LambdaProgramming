package com.java.lambda;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015-12-06 10:43
 * Declaration: All Rights Reserved !!!
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class IntegerSum {

    private static final int size = Integer.getInteger("sum.size", 1000000);

    public int[] array;
    public List<Integer> arrayList;
    public LinkedList<Integer> linkedList;
    public TreeSet<Integer> treeSet;
    public HashSet<Integer> hashSet;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {".*IntegerSum.*", "-wi", "10", "-i", "20", "-f", "1"};
        Main.main(args);
    }

    private Stream<Integer> numbers() {
        return IntStream.range(0, size).mapToObj(i -> i);
    }

    @Setup
    public void createDataSources() {
        array = IntStream.range(0, size).toArray();
        arrayList = numbers().collect(Collectors.toList());
        linkedList = new LinkedList<>(arrayList);
        treeSet = new TreeSet<>(arrayList);
        hashSet = new HashSet<>(arrayList);
    }

    @GenerateMicroBenchmark
    public int range() {
        return IntStream.range(0, size).parallel().sum();
    }

    @GenerateMicroBenchmark
    public int serialRange() {
        return IntStream.range(0, size).sum();
    }

    @GenerateMicroBenchmark
    public int array() {
        return IntStream.of(array).parallel().sum();
    }

    @GenerateMicroBenchmark
    public int arrayList() {
        return arrayList.parallelStream().mapToInt(i -> i).sum();
    }

    private int addIntegers(List<Integer> values) {
        return values.parallelStream()
                .mapToInt(i -> i)
                .sum();
    }

    @GenerateMicroBenchmark
    public int linkedList() {
        return linkedList.parallelStream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int treeSet() {
        return treeSet.parallelStream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int hashSet() {
        return hashSet.parallelStream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int serialArray() {
        return IntStream.of(array).sum();
    }

    @GenerateMicroBenchmark
    public int serialArrayList() {
        return arrayList.stream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int serialLinkedList() {
        return linkedList.stream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int serialTreeSet() {
        return treeSet.stream().mapToInt(i -> i).sum();
    }

    @GenerateMicroBenchmark
    public int serialHashSet() {
        return hashSet.stream().mapToInt(i -> i).sum();
    }
}
