package com.java.lambda;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author: 王俊超
 * Date: 2015-12-06 10:16
 * Declaration: All Rights Reserved !!!
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class DiceRolls {

    private static final int N = 100_000_000;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {".*DiceRolls.*", "-wi", "5", "-i", "5"
        };
        Main.main(args);
    }

    @GenerateMicroBenchmark
    public Map<Integer, Double> serialDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> fraction)));
    }

    @GenerateMicroBenchmark
    public Map<Integer, Double> parallelDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> fraction)));
    }

    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1, 7);
            int secondThrow = random.nextInt(1, 7);
            return firstThrow + secondThrow;
        };
    }
}
