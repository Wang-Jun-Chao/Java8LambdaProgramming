package com.java.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:19
 * All Rights Reserved !!!
 */
public class DependencyInversionPrinciple {
    public static interface HeadingFinder {
        public List<String> findHeadings(Reader reader);
    }

    public static class NoDIP implements HeadingFinder {
        @Override
        public List<String> findHeadings(Reader input) {
            try (BufferedReader reader = new BufferedReader(input)) {
                return reader.lines()
                        .filter(line -> line.endsWith(":"))
                        .map(line -> line.substring(0, line.length() - 1))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new HeadingLookupException(e);
            }
        }
    }

    public static class ExtractedDIP implements HeadingFinder {

        @Override
        public List<String> findHeadings(Reader reader) {
            return withLinesOf(reader,
                    lines -> lines
                            .filter(line -> line.endsWith(":"))
                            .map(line -> line.substring(0, line.length() - 1))
                            .collect(Collectors.toList()),
                    HeadingLookupException::new);
        }

        private <T> T withLinesOf(Reader input,
                                  Function<Stream<String>, T> handler,
                                  Function<IOException, RuntimeException> error) {
            try (BufferedReader reader = new BufferedReader(input)) {
                return handler.apply(reader.lines());
            } catch (IOException e) {
                throw error.apply(e);
            }
        }

    }


}
