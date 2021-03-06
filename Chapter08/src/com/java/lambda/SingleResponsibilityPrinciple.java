package com.java.lambda;

import java.util.stream.IntStream;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:36
 * All Rights Reserved !!!
 */
public class SingleResponsibilityPrinciple {
    public static interface PrimeCounter {
        long countPrimes(int upTo);
    }

    public static class ImperativeSingleMethodPrimeCounter implements PrimeCounter {

        @Override
        public long countPrimes(int upTo) {
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    tally++;
                }
            }
            return tally;
        }
    }

    public static class ImperativeRefactoredPrimeCounter implements PrimeCounter {

        @Override
        public long countPrimes(int upTo) {
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                if (isPrime(i)) {
                    tally++;
                }
            }
            return tally;
        }

        private boolean isPrime(int number) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class FunctionalPrimeCounter implements PrimeCounter {

        @Override
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo).filter(this::isPrime).count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number).allMatch(x -> (number % x) != 0);
        }
    }

    public static class ParallelFunctionalPrimeCounter implements PrimeCounter {


        @Override
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo).parallel().filter(this::isPrime).count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number).allMatch(x -> (number % x) != 0);
        }
    }
}
